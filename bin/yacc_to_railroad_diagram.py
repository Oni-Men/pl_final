#!/usr/bin env python
# -*- coding: utf-8 -*-

import os
import re
import time
import urllib.request

YaccSyntaxFile = "front/syns.yac"
LexPatternFile = "front/rexp.lex"


def read_pattern_part(pattern_file):
    """lexの正規表現部を読み取る"""
    def force_quote(s): return s  # return '"' + s.strip('"') + '"'
    def unescape(s): return re.sub(r'\\(.)', r'\1', s)

    boundary = "%%"
    pattern_part_lines = []
    with open(pattern_file) as f:
        inside_pattern = False
        lines = f.readlines()
        for line in lines:
            line = line.split("\n")[0]
            if line == boundary:
                inside_pattern = not inside_pattern
            else:
                if inside_pattern:
                    result = re.match(
                        '([^\s]+)\s*{\s*return\s*\((.+)\);\s*}', line)
                    if result is not None:
                        pattern = force_quote(result[1])
                        pattern = unescape(pattern)
                        token = result[2]
                        pattern_part_lines.append((pattern, token))

    return pattern_part_lines


def read_syntax_part(syntax_file):
    """yaccの構文規則部を読み取る"""
    boundary = "%%"
    syntax_part_lines = []
    with open(syntax_file) as f:
        inside_syntax = False
        lines = f.readlines()
        for line in lines:
            line = line.split("\n")[0]
            if line == boundary:
                inside_syntax = not inside_syntax
            else:
                if inside_syntax:
                    syntax_part_lines.append(line)

    return syntax_part_lines


def strip_semantic_process(syntaxes, tokens):
    """意味解析の部分を取り除き，規則のリストにする"""
    result = []

    text = '\n'.join(syntaxes)
    while True:
        syntax = re.match('((.|\s)+?)\s*{.+}', text, flags=re.MULTILINE)
        if syntax is None:
            break

        stripped = re.sub(':', '::=', syntax[1], count=1)
        for token in tokens:
            stripped = re.sub(f"\\s{token[1]}",
                              " " + token[0], stripped)

        result.append(stripped.strip("\n"))
        text = text[len(syntax[0]):]

    return '\n'.join(result)


def download(text):
    url = "https://rr.red-dove.com/ui"
    headers = {
        "accept-encoding": "gzip, deflate, br, zstd"
    }
    data = {
        "tz": "-540",
        "task": "DOWNLOAD",
        "text": text,
        "time": int(time.time()),
        "name": "",
        "frame": "",
        "spec": "",
        "uri": "",
        "color": "#FFDB4D",
        "download-options": "md+svg",
        "options": "showebnf",
        "rgb": "#ffffff",
        "hue": "0",
        "saturation": "0",
        "lightness": "100",
        "spread": "0",
        "width": 992,
        "padding": 10,
        "strokewidth": 1,
        "options": "eliminaterecursion",
        "options": "factoring",
        "options": "inline",
        "options": "keep",
    }
    data = urllib.parse.urlencode(data)
    data = data.encode('utf-8')

    request = urllib.request.Request(url, data, headers, method="post")
    with urllib.request.urlopen(request) as response:
        with open("docs/diagram.zip", "wb") as output_file:
            output_file.write(response.read())


def main():
    syntax_file = os.path.join(os.getcwd(), YaccSyntaxFile)
    pattern_file = os.path.join(os.getcwd(), LexPatternFile)
    syntaxes = read_syntax_part(syntax_file)
    tokens = read_pattern_part(pattern_file)
    text = strip_semantic_process(syntaxes, tokens)

    print(text)
    return 0


if __name__ == "__main__":
    import sys

    sys.exit(main())
