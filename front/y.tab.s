	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 14, 0	sdk_version 15, 0
	.globl	_yyparse                        ## -- Begin function yyparse
	.p2align	4, 0x90
_yyparse:                               ## @yyparse
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$2040, %rsp                     ## imm = 0x7F8
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	___stack_chk_guard@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, -48(%rbp)
	movq	_yynerrs@GOTPCREL(%rip), %rax
	movl	$0, (%rax)
	movq	_yychar@GOTPCREL(%rip), %r13
	movl	$-2, (%r13)
	xorl	%ebx, %ebx
	movl	$200, %r12d
	leaq	-2048(%rbp), %rcx
	leaq	-448(%rbp), %rax
	movq	%rax, %rdi
	movq	%rax, %r8
	movq	%rcx, -2080(%rbp)               ## 8-byte Spill
	movq	%rcx, %r9
	jmp	LBB0_4
	.p2align	4, 0x90
LBB0_1:                                 ##   in Loop: Header=BB0_4 Depth=1
	leaq	_yydefgoto(%rip), %rcx
	movsbl	-33(%rax,%rcx), %ebx
LBB0_2:                                 ##   in Loop: Header=BB0_4 Depth=1
	movq	%r14, %r12
LBB0_3:                                 ##   in Loop: Header=BB0_4 Depth=1
	addq	$2, %r8
LBB0_4:                                 ## =>This Inner Loop Header: Depth=1
	movw	%bx, (%r8)
	leaq	(%rdi,%r12,2), %rax
	addq	$-2, %rax
	cmpq	%r8, %rax
	ja	LBB0_11
## %bb.5:                               ##   in Loop: Header=BB0_4 Depth=1
	cmpq	$9999, %r12                     ## imm = 0x270F
	ja	LBB0_89
## %bb.6:                               ##   in Loop: Header=BB0_4 Depth=1
	movq	%r8, %r13
	movq	%rdi, %r14
	addq	%r12, %r12
	cmpq	$10000, %r12                    ## imm = 0x2710
	movl	$10000, %eax                    ## imm = 0x2710
	cmovaeq	%rax, %r12
	leaq	(%r12,%r12,4), %rax
	leaq	7(,%rax,2), %rdi
	callq	_malloc
	testq	%rax, %rax
	je	LBB0_89
## %bb.7:                               ##   in Loop: Header=BB0_4 Depth=1
	movq	%rax, %r15
	subq	%r14, %r13
	sarq	%r13
	movq	%r13, -2064(%rbp)               ## 8-byte Spill
	incq	%r13
	leaq	(,%r13,2), %rdx
	movq	%rax, %rdi
	movq	%r14, %rsi
	callq	_memcpy
	movq	%r12, -2056(%rbp)               ## 8-byte Spill
	leaq	7(,%r12,2), %r12
	andq	$-8, %r12
	addq	%r15, %r12
	leaq	(,%r13,8), %rdx
	movq	%r12, %rdi
	movq	-2080(%rbp), %rsi               ## 8-byte Reload
	callq	_memcpy
	leaq	-448(%rbp), %rax
	cmpq	%rax, %r14
	je	LBB0_9
## %bb.8:                               ##   in Loop: Header=BB0_4 Depth=1
	movq	%r14, %rdi
	callq	_free
LBB0_9:                                 ##   in Loop: Header=BB0_4 Depth=1
	cmpq	%r13, -2056(%rbp)               ## 8-byte Folded Reload
	jle	LBB0_84
## %bb.10:                              ##   in Loop: Header=BB0_4 Depth=1
	movq	-2064(%rbp), %r8                ## 8-byte Reload
	leaq	(%r15,%r8,2), %r8
	leaq	(%r12,%r13,8), %r9
	addq	$-8, %r9
	movq	%r15, %rdi
	movq	%r12, -2080(%rbp)               ## 8-byte Spill
	movq	_yychar@GOTPCREL(%rip), %r13
	movq	-2056(%rbp), %r12               ## 8-byte Reload
LBB0_11:                                ## %.thread295
                                        ##   in Loop: Header=BB0_4 Depth=1
	movslq	%ebx, %rbx
	leaq	_yypact(%rip), %rax
	movsbl	(%rbx,%rax), %r15d
	cmpl	$-52, %r15d
	je	LBB0_25
## %bb.12:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	(%r13), %eax
	cmpl	$-2, %eax
	jne	LBB0_14
## %bb.13:                              ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	%r8, %r13
	movq	%r9, %r14
	callq	_yylex
	movq	%r14, %r9
	movq	%r13, %r8
	movq	_yychar@GOTPCREL(%rip), %r13
	movq	-2056(%rbp), %rdi               ## 8-byte Reload
	movl	%eax, (%r13)
LBB0_14:                                ##   in Loop: Header=BB0_4 Depth=1
	testl	%eax, %eax
	jle	LBB0_17
## %bb.15:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	$2, %ecx
	cmpl	$287, %eax                      ## imm = 0x11F
	ja	LBB0_18
## %bb.16:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	%eax, %ecx
	leaq	_yytranslate(%rip), %rdx
	movzbl	(%rcx,%rdx), %ecx
	jmp	LBB0_18
LBB0_17:                                ##   in Loop: Header=BB0_4 Depth=1
	movl	$0, (%r13)
	xorl	%ecx, %ecx
LBB0_18:                                ##   in Loop: Header=BB0_4 Depth=1
	addl	%ecx, %r15d
	cmpl	$127, %r15d
	ja	LBB0_25
## %bb.19:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	%r15d, %edx
	leaq	_yycheck(%rip), %rsi
	movsbl	(%rdx,%rsi), %esi
	cmpl	%esi, %ecx
	jne	LBB0_25
## %bb.20:                              ##   in Loop: Header=BB0_4 Depth=1
	leaq	_yytable(%rip), %rcx
	movsbl	(%rdx,%rcx), %ebx
	testl	%ebx, %ebx
	jle	LBB0_29
## %bb.21:                              ##   in Loop: Header=BB0_4 Depth=1
	cmpl	$15, %r15d
	je	LBB0_88
## %bb.22:                              ##   in Loop: Header=BB0_4 Depth=1
	testl	%eax, %eax
	jle	LBB0_24
## %bb.23:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	$-2, (%r13)
LBB0_24:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	_yylval@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, 8(%r9)
	addq	$8, %r9
	jmp	LBB0_3
	.p2align	4, 0x90
LBB0_25:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%r12, %r14
	leaq	_yydefact(%rip), %rax
	movzbl	(%rbx,%rax), %ebx
	testl	%ebx, %ebx
	je	LBB0_90
LBB0_26:                                ##   in Loop: Header=BB0_4 Depth=1
	movl	%ebx, %edx
	leaq	_yyr2(%rip), %rax
	movzbl	(%rdx,%rax), %r12d
	addl	$-2, %ebx
	cmpl	$62, %ebx
	ja	LBB0_42
## %bb.27:                              ##   in Loop: Header=BB0_4 Depth=1
	leaq	LJTI0_0(%rip), %rcx
	movslq	(%rcx,%rbx,4), %rax
	addq	%rcx, %rax
	jmpq	*%rax
LBB0_43:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	(%r9), %r15
	jmp	LBB0_81
LBB0_36:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	-8(%r9), %r15
	jmp	LBB0_81
LBB0_29:                                ##   in Loop: Header=BB0_4 Depth=1
	addl	$-125, %r15d
	cmpl	$2, %r15d
	jb	LBB0_90
## %bb.30:                              ##   in Loop: Header=BB0_4 Depth=1
	movq	%r12, %r14
	negl	%ebx
	jmp	LBB0_26
LBB0_33:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.20(%rip), %rdi
	jmp	LBB0_75
LBB0_35:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	(%r9), %r15
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	%r15, %rdi
	movq	%r8, %rbx
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, -2072(%rbp)               ## 8-byte Spill
	callq	_tree
	movq	-2072(%rbp), %rdx               ## 8-byte Reload
	movq	-2064(%rbp), %r9                ## 8-byte Reload
	movq	%rbx, %r8
	movq	-2056(%rbp), %rdi               ## 8-byte Reload
	jmp	LBB0_81
LBB0_37:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str(%rip), %rdi
	jmp	LBB0_75
LBB0_38:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.4(%rip), %rdi
	jmp	LBB0_75
LBB0_39:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.5(%rip), %rdi
	jmp	LBB0_75
LBB0_40:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.6(%rip), %rdi
	jmp	LBB0_75
LBB0_42:                                ##   in Loop: Header=BB0_4 Depth=1
	movl	$1, %eax
	subq	%r12, %rax
	movq	(%r9,%rax,8), %r15
	jmp	LBB0_81
LBB0_44:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	(%r9), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.1(%rip), %rdi
	jmp	LBB0_51
LBB0_45:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-24(%r9), %rdi
	movq	-8(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.2(%rip), %rdi
	jmp	LBB0_75
LBB0_46:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	-8(%r9), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.3(%rip), %rdi
	jmp	LBB0_51
LBB0_48:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.7(%rip), %rdi
	jmp	LBB0_75
LBB0_50:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	-8(%r9), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.8(%rip), %rdi
LBB0_51:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%r8, %r15
	movq	%r9, %rbx
	movq	%rdx, -2072(%rbp)               ## 8-byte Spill
	callq	_node
	jmp	LBB0_79
LBB0_53:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.9(%rip), %rdi
	jmp	LBB0_75
LBB0_55:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.10(%rip), %rdi
	jmp	LBB0_75
LBB0_57:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.11(%rip), %rdi
	jmp	LBB0_75
LBB0_58:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.12(%rip), %rdi
	jmp	LBB0_75
LBB0_59:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.13(%rip), %rdi
	jmp	LBB0_75
LBB0_60:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.14(%rip), %rdi
	jmp	LBB0_75
LBB0_62:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-24(%r9), %rdi
	movq	-8(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.15(%rip), %rdi
	jmp	LBB0_75
LBB0_63:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.16(%rip), %rdi
	jmp	LBB0_75
LBB0_64:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.17(%rip), %rdi
	jmp	LBB0_75
LBB0_65:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.18(%rip), %rdi
	jmp	LBB0_75
LBB0_66:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.19(%rip), %rdi
	jmp	LBB0_75
LBB0_70:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-16(%r9), %rdi
	movq	(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.21(%rip), %rdi
	jmp	LBB0_75
LBB0_72:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.22(%rip), %rdi
	jmp	LBB0_78
LBB0_73:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.23(%rip), %rdi
	jmp	LBB0_78
LBB0_74:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	movq	-24(%r9), %rdi
	movq	-8(%r9), %rsi
	movq	%r8, %r15
	movq	%r9, -2064(%rbp)                ## 8-byte Spill
	movq	%rdx, %rbx
	callq	_cons
	leaq	L_.str.24(%rip), %rdi
	.p2align	4, 0x90
LBB0_75:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%rax, %rsi
	callq	_node
	movq	%rbx, %rdx
	movq	-2064(%rbp), %r9                ## 8-byte Reload
	jmp	LBB0_80
LBB0_76:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.25(%rip), %rdi
	jmp	LBB0_78
LBB0_77:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rsi
	movq	%rdi, -2056(%rbp)               ## 8-byte Spill
	leaq	L_.str.26(%rip), %rdi
LBB0_78:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%r8, %r15
	movq	%r9, %rbx
	movq	%rdx, -2072(%rbp)               ## 8-byte Spill
	callq	_leaf
LBB0_79:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	-2072(%rbp), %rdx               ## 8-byte Reload
	movq	%rbx, %r9
LBB0_80:                                ##   in Loop: Header=BB0_4 Depth=1
	movq	%r15, %r8
	movq	-2056(%rbp), %rdi               ## 8-byte Reload
	movq	%rax, %r15
LBB0_81:                                ##   in Loop: Header=BB0_4 Depth=1
	leaq	(,%r12,8), %rax
	subq	%rax, %r9
	addq	%r12, %r12
	subq	%r12, %r8
	movq	%r15, 8(%r9)
	addq	$8, %r9
	leaq	_yyr1(%rip), %rax
	movzbl	(%rdx,%rax), %eax
	leaq	_yypgoto(%rip), %rcx
	movsbl	-33(%rax,%rcx), %edx
	movswl	(%r8), %ecx
	addl	%ecx, %edx
	cmpl	$127, %edx
	ja	LBB0_1
## %bb.82:                              ##   in Loop: Header=BB0_4 Depth=1
	movl	%edx, %edx
	leaq	_yycheck(%rip), %rsi
	movsbl	(%rdx,%rsi), %esi
	cmpw	%si, %cx
	jne	LBB0_1
## %bb.83:                              ##   in Loop: Header=BB0_4 Depth=1
	leaq	_yytable(%rip), %rax
	movsbl	(%rdx,%rax), %ebx
	jmp	LBB0_2
LBB0_84:
	movl	$1, %r14d
	movq	%r15, %rdi
LBB0_85:                                ## %.thread302.thread
	callq	_free
LBB0_86:
	movq	___stack_chk_guard@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	cmpq	-48(%rbp), %rax
	jne	LBB0_92
## %bb.87:
	movl	%r14d, %eax
	addq	$2040, %rsp                     ## imm = 0x7F8
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB0_88:                                ## %.thread302
	xorl	%r14d, %r14d
	leaq	-448(%rbp), %rax
	cmpq	%rax, %rdi
	jne	LBB0_85
	jmp	LBB0_86
LBB0_89:
	movq	___stderrp@GOTPCREL(%rip), %rax
	movq	(%rax), %rdi
	movl	_linecounter(%rip), %ecx
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %r8
	leaq	L_.str.39(%rip), %rsi
	leaq	L_.str.30(%rip), %rdx
	jmp	LBB0_91
LBB0_90:
	movq	_yynerrs@GOTPCREL(%rip), %rax
	incl	(%rax)
	movq	___stderrp@GOTPCREL(%rip), %rax
	movq	(%rax), %rdi
	movl	_linecounter(%rip), %ecx
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %r8
	leaq	L_.str.39(%rip), %rsi
	leaq	L_.str.27(%rip), %rdx
LBB0_91:
	xorl	%eax, %eax
	callq	_fprintf
	movl	$1, %edi
	callq	_exit
LBB0_92:
	callq	___stack_chk_fail
	.cfi_endproc
	.p2align	2, 0x90
	.data_region jt32
.set L0_0_set_43, LBB0_43-LJTI0_0
.set L0_0_set_35, LBB0_35-LJTI0_0
.set L0_0_set_36, LBB0_36-LJTI0_0
.set L0_0_set_37, LBB0_37-LJTI0_0
.set L0_0_set_44, LBB0_44-LJTI0_0
.set L0_0_set_45, LBB0_45-LJTI0_0
.set L0_0_set_46, LBB0_46-LJTI0_0
.set L0_0_set_38, LBB0_38-LJTI0_0
.set L0_0_set_39, LBB0_39-LJTI0_0
.set L0_0_set_40, LBB0_40-LJTI0_0
.set L0_0_set_48, LBB0_48-LJTI0_0
.set L0_0_set_50, LBB0_50-LJTI0_0
.set L0_0_set_53, LBB0_53-LJTI0_0
.set L0_0_set_55, LBB0_55-LJTI0_0
.set L0_0_set_57, LBB0_57-LJTI0_0
.set L0_0_set_58, LBB0_58-LJTI0_0
.set L0_0_set_59, LBB0_59-LJTI0_0
.set L0_0_set_60, LBB0_60-LJTI0_0
.set L0_0_set_62, LBB0_62-LJTI0_0
.set L0_0_set_63, LBB0_63-LJTI0_0
.set L0_0_set_64, LBB0_64-LJTI0_0
.set L0_0_set_65, LBB0_65-LJTI0_0
.set L0_0_set_66, LBB0_66-LJTI0_0
.set L0_0_set_33, LBB0_33-LJTI0_0
.set L0_0_set_70, LBB0_70-LJTI0_0
.set L0_0_set_72, LBB0_72-LJTI0_0
.set L0_0_set_73, LBB0_73-LJTI0_0
.set L0_0_set_74, LBB0_74-LJTI0_0
.set L0_0_set_76, LBB0_76-LJTI0_0
.set L0_0_set_77, LBB0_77-LJTI0_0
LJTI0_0:
	.long	L0_0_set_43
	.long	L0_0_set_35
	.long	L0_0_set_35
	.long	L0_0_set_36
	.long	L0_0_set_36
	.long	L0_0_set_37
	.long	L0_0_set_37
	.long	L0_0_set_44
	.long	L0_0_set_45
	.long	L0_0_set_46
	.long	L0_0_set_38
	.long	L0_0_set_39
	.long	L0_0_set_43
	.long	L0_0_set_40
	.long	L0_0_set_48
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_36
	.long	L0_0_set_50
	.long	L0_0_set_43
	.long	L0_0_set_53
	.long	L0_0_set_43
	.long	L0_0_set_55
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_36
	.long	L0_0_set_57
	.long	L0_0_set_58
	.long	L0_0_set_59
	.long	L0_0_set_60
	.long	L0_0_set_43
	.long	L0_0_set_62
	.long	L0_0_set_63
	.long	L0_0_set_64
	.long	L0_0_set_65
	.long	L0_0_set_66
	.long	L0_0_set_43
	.long	L0_0_set_33
	.long	L0_0_set_43
	.long	L0_0_set_36
	.long	L0_0_set_43
	.long	L0_0_set_33
	.long	L0_0_set_38
	.long	L0_0_set_39
	.long	L0_0_set_43
	.long	L0_0_set_40
	.long	L0_0_set_70
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_36
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_43
	.long	L0_0_set_33
	.long	L0_0_set_72
	.long	L0_0_set_73
	.long	L0_0_set_74
	.long	L0_0_set_76
	.long	L0_0_set_77
	.end_data_region
                                        ## -- End function
	.globl	_yylex                          ## -- Begin function yylex
	.p2align	4, 0x90
_yylex:                                 ## @yylex
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	cmpb	$0, _yy_init(%rip)
	jne	LBB1_13
## %bb.1:
	movb	$1, _yy_init(%rip)
	cmpb	$0, _yy_start(%rip)
	je	LBB1_2
## %bb.3:
	cmpq	$0, _yyin(%rip)
	je	LBB1_4
LBB1_5:
	cmpq	$0, _yyout(%rip)
	je	LBB1_6
LBB1_7:
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rax, %rax
	je	LBB1_9
## %bb.8:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rbx
	testq	%rbx, %rbx
	jne	LBB1_12
LBB1_9:
	callq	_yyensure_buffer_stack
	movq	_yyin(%rip), %r14
	movl	$72, %edi
	callq	_malloc
	testq	%rax, %rax
	je	LBB1_109
## %bb.10:
	movq	%rax, %rbx
	movl	$16384, 24(%rax)                ## imm = 0x4000
	movl	$16386, %edi                    ## imm = 0x4002
	callq	_malloc
	movq	%rax, 8(%rbx)
	testq	%rax, %rax
	je	LBB1_109
## %bb.11:                              ## %yy_create_buffer.exit
	movl	$1, 40(%rbx)
	movq	%rbx, %rdi
	movq	%r14, %rsi
	callq	_yy_init_buffer
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	%rbx, (%rax,%rcx,8)
LBB1_12:
	movq	32(%rbx), %rdx
	movq	%rdx, _yy_n_chars(%rip)
	movq	16(%rbx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%rdx), %eax
	movb	%al, _yy_hold_char(%rip)
LBB1_13:                                ## %yy_get_previous_state.exit89.thread.preheader
	movabsq	$282024732524551, %r10          ## imm = 0x1008000000007
	leaq	_yy_ec(%rip), %r11
	leaq	_yy_base(%rip), %r12
	leaq	_yy_chk(%rip), %r13
	leaq	_yy_nxt(%rip), %r9
	leaq	_yy_def(%rip), %r15
LBB1_14:                                ## %yy_get_previous_state.exit89.thread
                                        ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB1_15 Depth 2
                                        ##       Child Loop BB1_16 Depth 3
                                        ##         Child Loop BB1_19 Depth 4
                                        ##         Child Loop BB1_21 Depth 4
                                        ##           Child Loop BB1_22 Depth 5
                                        ##             Child Loop BB1_66 Depth 6
                                        ##               Child Loop BB1_72 Depth 7
                                        ##             Child Loop BB1_77 Depth 6
                                        ##           Child Loop BB1_93 Depth 5
                                        ##             Child Loop BB1_99 Depth 6
                                        ##         Child Loop BB1_83 Depth 4
                                        ##           Child Loop BB1_89 Depth 5
	movq	_yy_c_buf_p(%rip), %r14
	movzbl	_yy_hold_char(%rip), %eax
	movb	%al, (%r14)
	movzbl	_yy_start(%rip), %ecx
	movq	%r14, %rax
LBB1_15:                                ## %.loopexit113
                                        ##   Parent Loop BB1_14 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB1_16 Depth 3
                                        ##         Child Loop BB1_19 Depth 4
                                        ##         Child Loop BB1_21 Depth 4
                                        ##           Child Loop BB1_22 Depth 5
                                        ##             Child Loop BB1_66 Depth 6
                                        ##               Child Loop BB1_72 Depth 7
                                        ##             Child Loop BB1_77 Depth 6
                                        ##           Child Loop BB1_93 Depth 5
                                        ##             Child Loop BB1_99 Depth 6
                                        ##         Child Loop BB1_83 Depth 4
                                        ##           Child Loop BB1_89 Depth 5
	movabsq	$314871806197360, %rbx          ## imm = 0x11E5FCE287E70
	jmp	LBB1_16
	.p2align	4, 0x90
LBB1_20:                                ## %._crit_edge
                                        ##   in Loop: Header=BB1_16 Depth=3
	movswl	(%r9,%rdi,2), %ecx
	incq	%r14
	btq	%rcx, %rbx
	jb	LBB1_21
LBB1_16:                                ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ## =>    This Loop Header: Depth=3
                                        ##         Child Loop BB1_19 Depth 4
                                        ##         Child Loop BB1_21 Depth 4
                                        ##           Child Loop BB1_22 Depth 5
                                        ##             Child Loop BB1_66 Depth 6
                                        ##               Child Loop BB1_72 Depth 7
                                        ##             Child Loop BB1_77 Depth 6
                                        ##           Child Loop BB1_93 Depth 5
                                        ##             Child Loop BB1_99 Depth 6
                                        ##         Child Loop BB1_83 Depth 4
                                        ##           Child Loop BB1_89 Depth 5
	movzbl	(%r14), %edx
	movzbl	(%rdx,%r11), %edx
	btq	%rcx, %r10
	jb	LBB1_18
## %bb.17:                              ##   in Loop: Header=BB1_16 Depth=3
	movl	%ecx, _yy_last_accepting_state(%rip)
	movq	%r14, _yy_last_accepting_cpos(%rip)
LBB1_18:                                ##   in Loop: Header=BB1_16 Depth=3
	movslq	%ecx, %rsi
	movswq	(%r12,%rsi,2), %rdi
	addq	%rdx, %rdi
	movswl	(%r13,%rdi,2), %r8d
	cmpl	%r8d, %ecx
	je	LBB1_20
	.p2align	4, 0x90
LBB1_19:                                ## %.lr.ph
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ## =>      This Inner Loop Header: Depth=4
	movswq	(%r15,%rsi,2), %rsi
	movswq	(%r12,%rsi,2), %rdi
	addq	%rdx, %rdi
	cmpw	(%r13,%rdi,2), %si
	jne	LBB1_19
	jmp	LBB1_20
	.p2align	4, 0x90
LBB1_21:                                ## %.preheader.outer.preheader
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ## =>      This Loop Header: Depth=4
                                        ##           Child Loop BB1_22 Depth 5
                                        ##             Child Loop BB1_66 Depth 6
                                        ##               Child Loop BB1_72 Depth 7
                                        ##             Child Loop BB1_77 Depth 6
                                        ##           Child Loop BB1_93 Depth 5
                                        ##             Child Loop BB1_99 Depth 6
	movq	_yytext@GOTPCREL(%rip), %rsi
LBB1_22:                                ## %.preheader
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ## =>        This Loop Header: Depth=5
                                        ##             Child Loop BB1_66 Depth 6
                                        ##               Child Loop BB1_72 Depth 7
                                        ##             Child Loop BB1_77 Depth 6
	btq	%rcx, %r10
	jae	LBB1_23
## %bb.24:                              ## %.preheader
                                        ##   in Loop: Header=BB1_22 Depth=5
	movslq	_yy_last_accepting_state(%rip), %rcx
	movq	_yy_last_accepting_cpos(%rip), %r14
	jmp	LBB1_25
	.p2align	4, 0x90
LBB1_23:                                ##   in Loop: Header=BB1_22 Depth=5
	movslq	%ecx, %rcx
LBB1_25:                                ## %.preheader
                                        ##   in Loop: Header=BB1_22 Depth=5
	leaq	_yy_accept(%rip), %rdx
	movswl	(%rdx,%rcx,2), %ecx
	movq	%rax, (%rsi)
	movq	%r14, %rdx
	subq	%rax, %rdx
	movq	_yyleng@GOTPCREL(%rip), %rdi
	movq	%rdx, (%rdi)
	movzbl	(%r14), %edx
	movb	%dl, _yy_hold_char(%rip)
	movb	$0, (%r14)
	movq	%r14, _yy_c_buf_p(%rip)
	cmpl	$38, %ecx
	ja	LBB1_101
## %bb.26:                              ## %.preheader
                                        ##   in Loop: Header=BB1_22 Depth=5
	xorl	%ebx, %ebx
	leaq	LJTI1_0(%rip), %rdx
	movslq	(%rdx,%rcx,4), %rcx
	addq	%rdx, %rcx
	jmpq	*%rcx
LBB1_35:                                ##   in Loop: Header=BB1_22 Depth=5
	movzbl	_yy_hold_char(%rip), %ecx
	movb	%cl, (%r14)
	movq	_yy_last_accepting_cpos(%rip), %r14
	movl	_yy_last_accepting_state(%rip), %ecx
	jmp	LBB1_22
LBB1_27:                                ##   in Loop: Header=BB1_22 Depth=5
	movq	(%rsi), %r8
	movzbl	_yy_hold_char(%rip), %eax
	movb	%al, (%r14)
	movq	_yy_buffer_stack(%rip), %rdx
	movq	_yy_buffer_stack_top(%rip), %rsi
	movq	(%rdx,%rsi,8), %rax
	cmpl	$0, 64(%rax)
	je	LBB1_29
## %bb.28:                              ## %._crit_edge313.peel
                                        ##   in Loop: Header=BB1_22 Depth=5
	movq	_yy_n_chars(%rip), %rcx
	jmp	LBB1_30
LBB1_29:                                ##   in Loop: Header=BB1_22 Depth=5
	movq	32(%rax), %rcx
	movq	%rcx, _yy_n_chars(%rip)
	movq	_yyin(%rip), %rdi
	movq	%rdi, (%rax)
	movq	(%rdx,%rsi,8), %rax
	movl	$1, 64(%rax)
LBB1_30:                                ##   in Loop: Header=BB1_22 Depth=5
	addq	8(%rax), %rcx
	cmpq	%rcx, _yy_c_buf_p(%rip)
	jbe	LBB1_64
## %bb.31:                              ##   in Loop: Header=BB1_22 Depth=5
	movq	%r8, -48(%rbp)                  ## 8-byte Spill
	callq	_yy_get_next_buffer
	cmpl	$2, %eax
	jne	LBB1_32
## %bb.91:                              ## %.loopexit560
                                        ##   in Loop: Header=BB1_22 Depth=5
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	movq	8(%rax), %r14
	addq	_yy_n_chars(%rip), %r14
	movq	%r14, _yy_c_buf_p(%rip)
	movzbl	_yy_start(%rip), %ecx
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	(%rsi), %rax
	cmpq	%r14, %rax
	movabsq	$282024732524551, %r10          ## imm = 0x1008000000007
	leaq	_yy_ec(%rip), %r11
	leaq	_yy_nxt(%rip), %r9
	jae	LBB1_22
	jmp	LBB1_92
LBB1_64:                                ## %.loopexit554
                                        ##   in Loop: Header=BB1_22 Depth=5
	movl	%r14d, %edx
	subl	%r8d, %edx
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	leal	-1(%rdx), %ecx
	movslq	%ecx, %r14
	addq	%rax, %r14
	movq	%r14, _yy_c_buf_p(%rip)
	movzbl	_yy_start(%rip), %ecx
	cmpl	$2, %edx
	jl	LBB1_74
## %bb.65:                              ## %.lr.ph24.i.preheader
                                        ##   in Loop: Header=BB1_22 Depth=5
	movq	%rax, %rdx
	jmp	LBB1_66
	.p2align	4, 0x90
LBB1_73:                                ## %._crit_edge.i
                                        ##   in Loop: Header=BB1_66 Depth=6
	movq	%rbx, %r9
	movswl	(%rbx,%r8,2), %ecx
	incq	%rdx
	cmpq	%r14, %rdx
	je	LBB1_74
LBB1_66:                                ## %.lr.ph24.i
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ##           Parent Loop BB1_22 Depth=5
                                        ## =>          This Loop Header: Depth=6
                                        ##               Child Loop BB1_72 Depth 7
	movzbl	(%rdx), %esi
	testq	%rsi, %rsi
	je	LBB1_67
## %bb.68:                              ##   in Loop: Header=BB1_66 Depth=6
	movzbl	(%rsi,%r11), %esi
	jmp	LBB1_69
LBB1_67:                                ##   in Loop: Header=BB1_66 Depth=6
	movb	$1, %sil
LBB1_69:                                ##   in Loop: Header=BB1_66 Depth=6
	movq	%r9, %rbx
	btq	%rcx, %r10
	jb	LBB1_71
## %bb.70:                              ##   in Loop: Header=BB1_66 Depth=6
	movl	%ecx, _yy_last_accepting_state(%rip)
	movq	%rdx, _yy_last_accepting_cpos(%rip)
LBB1_71:                                ##   in Loop: Header=BB1_66 Depth=6
	movzbl	%sil, %esi
	movslq	%ecx, %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	movswl	(%r13,%r8,2), %r9d
	cmpl	%r9d, %ecx
	je	LBB1_73
	.p2align	4, 0x90
LBB1_72:                                ## %.lr.ph.i
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ##           Parent Loop BB1_22 Depth=5
                                        ##             Parent Loop BB1_66 Depth=6
                                        ## =>            This Inner Loop Header: Depth=7
	movswq	(%r15,%rdi,2), %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	cmpw	(%r13,%r8,2), %di
	jne	LBB1_72
	jmp	LBB1_73
LBB1_74:                                ## %yy_get_previous_state.exit
                                        ##   in Loop: Header=BB1_22 Depth=5
	btq	%rcx, %r10
	jb	LBB1_76
## %bb.75:                              ##   in Loop: Header=BB1_22 Depth=5
	movl	%ecx, _yy_last_accepting_state(%rip)
	movq	%r14, _yy_last_accepting_cpos(%rip)
LBB1_76:                                ##   in Loop: Header=BB1_22 Depth=5
	movslq	%ecx, %rsi
	movswq	(%r12,%rsi,2), %rdx
	movswl	2(%r13,%rdx,2), %edi
	cmpl	%edi, %ecx
	je	LBB1_78
	.p2align	4, 0x90
LBB1_77:                                ## %.lr.ph.i70
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ##           Parent Loop BB1_22 Depth=5
                                        ## =>          This Inner Loop Header: Depth=6
	movswq	(%r15,%rsi,2), %rsi
	movswq	(%r12,%rsi,2), %rdx
	cmpw	2(%r13,%rdx,2), %si
	jne	LBB1_77
LBB1_78:                                ##   in Loop: Header=BB1_22 Depth=5
	incq	%rdx
	testq	%rdx, %rdx
	movq	_yytext@GOTPCREL(%rip), %rsi
	je	LBB1_22
## %bb.79:                              ## %yy_try_NUL_trans.exit
                                        ##   in Loop: Header=BB1_22 Depth=5
	movzwl	(%r9,%rdx,2), %edx
	cmpw	$48, %dx
	je	LBB1_22
	jmp	LBB1_80
LBB1_92:                                ## %.lr.ph24.preheader.i92
                                        ##   in Loop: Header=BB1_21 Depth=4
	movq	%rax, %rdx
	jmp	LBB1_93
	.p2align	4, 0x90
LBB1_100:                               ## %._crit_edge.i102
                                        ##   in Loop: Header=BB1_93 Depth=5
	leaq	_yy_nxt(%rip), %r9
	movswl	(%r9,%r8,2), %ecx
	incq	%rdx
	cmpq	%r14, %rdx
	je	LBB1_21
LBB1_93:                                ## %.lr.ph24.i94
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ## =>        This Loop Header: Depth=5
                                        ##             Child Loop BB1_99 Depth 6
	movzbl	(%rdx), %esi
	testq	%rsi, %rsi
	je	LBB1_94
## %bb.95:                              ##   in Loop: Header=BB1_93 Depth=5
	movzbl	(%rsi,%r11), %esi
	btq	%rcx, %r10
	jb	LBB1_98
LBB1_97:                                ##   in Loop: Header=BB1_93 Depth=5
	movl	%ecx, _yy_last_accepting_state(%rip)
	movq	%rdx, _yy_last_accepting_cpos(%rip)
LBB1_98:                                ##   in Loop: Header=BB1_93 Depth=5
	movzbl	%sil, %esi
	movslq	%ecx, %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	movswl	(%r13,%r8,2), %r9d
	cmpl	%r9d, %ecx
	je	LBB1_100
	.p2align	4, 0x90
LBB1_99:                                ## %.lr.ph.i100
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_21 Depth=4
                                        ##           Parent Loop BB1_93 Depth=5
                                        ## =>          This Inner Loop Header: Depth=6
	movswq	(%r15,%rdi,2), %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	cmpw	(%r13,%r8,2), %di
	jne	LBB1_99
	jmp	LBB1_100
LBB1_94:                                ##   in Loop: Header=BB1_93 Depth=5
	movb	$1, %sil
	btq	%rcx, %r10
	jae	LBB1_97
	jmp	LBB1_98
LBB1_32:                                ##   in Loop: Header=BB1_16 Depth=3
	testl	%eax, %eax
	movabsq	$282024732524551, %r10          ## imm = 0x1008000000007
	leaq	_yy_ec(%rip), %r11
	leaq	_yy_nxt(%rip), %r9
	movq	_yytext@GOTPCREL(%rip), %rcx
	jne	LBB1_33
## %bb.81:                              ## %.loopexit557
                                        ##   in Loop: Header=BB1_16 Depth=3
	movl	%r14d, %edx
	subl	-48(%rbp), %edx                 ## 4-byte Folded Reload
	movq	(%rcx), %rax
	leal	-1(%rdx), %ecx
	movslq	%ecx, %r14
	addq	%rax, %r14
	movq	%r14, _yy_c_buf_p(%rip)
	movzbl	_yy_start(%rip), %ecx
	cmpl	$2, %edx
	movabsq	$314871806197360, %rbx          ## imm = 0x11E5FCE287E70
	jl	LBB1_16
## %bb.82:                              ## %.lr.ph24.i78.preheader
                                        ##   in Loop: Header=BB1_16 Depth=3
	movq	%rax, %rdx
	jmp	LBB1_83
LBB1_90:                                ## %._crit_edge.i86
                                        ##   in Loop: Header=BB1_83 Depth=4
	leaq	_yy_nxt(%rip), %r9
	movswl	(%r9,%r8,2), %ecx
	incq	%rdx
	cmpq	%r14, %rdx
	je	LBB1_16
LBB1_83:                                ## %.lr.ph24.i78
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ## =>      This Loop Header: Depth=4
                                        ##           Child Loop BB1_89 Depth 5
	movzbl	(%rdx), %esi
	testq	%rsi, %rsi
	je	LBB1_84
## %bb.85:                              ##   in Loop: Header=BB1_83 Depth=4
	movzbl	(%rsi,%r11), %esi
	jmp	LBB1_86
LBB1_84:                                ##   in Loop: Header=BB1_83 Depth=4
	movb	$1, %sil
LBB1_86:                                ##   in Loop: Header=BB1_83 Depth=4
	btq	%rcx, %r10
	jb	LBB1_88
## %bb.87:                              ##   in Loop: Header=BB1_83 Depth=4
	movl	%ecx, _yy_last_accepting_state(%rip)
	movq	%rdx, _yy_last_accepting_cpos(%rip)
LBB1_88:                                ##   in Loop: Header=BB1_83 Depth=4
	movzbl	%sil, %esi
	movslq	%ecx, %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	movswl	(%r13,%r8,2), %r9d
	cmpl	%r9d, %ecx
	je	LBB1_90
LBB1_89:                                ## %.lr.ph.i84
                                        ##   Parent Loop BB1_14 Depth=1
                                        ##     Parent Loop BB1_15 Depth=2
                                        ##       Parent Loop BB1_16 Depth=3
                                        ##         Parent Loop BB1_83 Depth=4
                                        ## =>        This Inner Loop Header: Depth=5
	movswq	(%r15,%rdi,2), %rdi
	movswq	(%r12,%rdi,2), %r8
	addq	%rsi, %r8
	cmpw	(%r13,%r8,2), %di
	jne	LBB1_89
	jmp	LBB1_90
LBB1_80:                                ##   in Loop: Header=BB1_15 Depth=2
	movswl	%dx, %ecx
	incq	%r14
	movq	%r14, _yy_c_buf_p(%rip)
	jmp	LBB1_15
LBB1_59:                                ## %.loopexit548
                                        ##   in Loop: Header=BB1_14 Depth=1
	incl	_linecounter(%rip)
	jmp	LBB1_14
LBB1_60:                                ## %.loopexit550
                                        ##   in Loop: Header=BB1_14 Depth=1
	movq	%r10, %rbx
	movq	%r11, %r14
	callq	_comment
	jmp	LBB1_61
LBB1_63:                                ## %.loopexit552
                                        ##   in Loop: Header=BB1_14 Depth=1
	movq	(%rsi), %rdi
	movq	_yyleng@GOTPCREL(%rip), %rax
	movq	(%rax), %rsi
	movq	_yyout(%rip), %rcx
	movl	$1, %edx
	movq	%r10, %rbx
	movq	%r11, %r14
	callq	_fwrite
LBB1_61:                                ## %yy_get_previous_state.exit89.thread
                                        ##   in Loop: Header=BB1_14 Depth=1
	leaq	_yy_nxt(%rip), %r9
	movq	%r14, %r11
	movq	%rbx, %r10
	jmp	LBB1_14
LBB1_33:                                ##   in Loop: Header=BB1_14 Depth=1
	cmpl	$1, %eax
	jne	LBB1_14
## %bb.34:                              ## %yy_get_previous_state.exit89.peel
	movq	(%rcx), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	jmp	LBB1_108
LBB1_2:
	movb	$1, _yy_start(%rip)
	cmpq	$0, _yyin(%rip)
	jne	LBB1_5
LBB1_4:
	movq	___stdinp@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	cmpq	$0, _yyout(%rip)
	jne	LBB1_7
LBB1_6:
	movq	___stdoutp@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, _yyout(%rip)
	jmp	LBB1_7
LBB1_102:                               ## %.loopexit
	movl	$258, %ebx                      ## imm = 0x102
	jmp	LBB1_108
LBB1_103:                               ## %.loopexit214
	movl	$259, %ebx                      ## imm = 0x103
	jmp	LBB1_108
LBB1_104:                               ## %.loopexit333
	movl	$260, %ebx                      ## imm = 0x104
	jmp	LBB1_108
LBB1_105:                               ## %.loopexit364
	movl	$261, %ebx                      ## imm = 0x105
	jmp	LBB1_108
LBB1_106:                               ## %.loopexit421
	movl	$262, %ebx                      ## imm = 0x106
	jmp	LBB1_108
LBB1_107:                               ## %.loopexit522.loopexit
	movl	$263, %ebx                      ## imm = 0x107
	jmp	LBB1_108
LBB1_36:                                ## %.loopexit523
	movl	$264, %ebx                      ## imm = 0x108
	jmp	LBB1_108
LBB1_37:                                ## %.loopexit524
	movl	$265, %ebx                      ## imm = 0x109
	jmp	LBB1_108
LBB1_38:                                ## %.loopexit525
	movl	$266, %ebx                      ## imm = 0x10A
	jmp	LBB1_108
LBB1_39:                                ## %.loopexit526
	movl	$267, %ebx                      ## imm = 0x10B
	jmp	LBB1_108
LBB1_40:                                ## %.loopexit527
	movl	$268, %ebx                      ## imm = 0x10C
	jmp	LBB1_108
LBB1_41:                                ## %.loopexit528
	movl	$269, %ebx                      ## imm = 0x10D
	jmp	LBB1_108
LBB1_42:                                ## %.loopexit529
	movl	$270, %ebx                      ## imm = 0x10E
	jmp	LBB1_108
LBB1_43:                                ## %.loopexit530
	movl	$271, %ebx                      ## imm = 0x10F
	jmp	LBB1_108
LBB1_44:                                ## %.loopexit531
	movl	$272, %ebx                      ## imm = 0x110
	jmp	LBB1_108
LBB1_45:                                ## %.loopexit532
	movl	$273, %ebx                      ## imm = 0x111
	jmp	LBB1_108
LBB1_46:                                ## %.loopexit533
	movl	$274, %ebx                      ## imm = 0x112
	jmp	LBB1_108
LBB1_47:                                ## %.loopexit534
	movl	$275, %ebx                      ## imm = 0x113
	jmp	LBB1_108
LBB1_48:                                ## %.loopexit535
	movl	$276, %ebx                      ## imm = 0x114
	jmp	LBB1_108
LBB1_49:                                ## %.loopexit536
	movl	$277, %ebx                      ## imm = 0x115
	jmp	LBB1_108
LBB1_50:                                ## %.loopexit537
	movl	$278, %ebx                      ## imm = 0x116
	jmp	LBB1_108
LBB1_51:                                ## %.loopexit538
	movl	$279, %ebx                      ## imm = 0x117
	jmp	LBB1_108
LBB1_52:                                ## %.loopexit539
	movl	$280, %ebx                      ## imm = 0x118
	jmp	LBB1_108
LBB1_53:                                ## %.loopexit540
	movl	$281, %ebx                      ## imm = 0x119
	jmp	LBB1_108
LBB1_54:                                ## %.loopexit541
	movl	$282, %ebx                      ## imm = 0x11A
	jmp	LBB1_108
LBB1_55:                                ## %.loopexit542
	movl	$283, %ebx                      ## imm = 0x11B
	jmp	LBB1_108
LBB1_56:                                ## %.loopexit543
	movl	$284, %ebx                      ## imm = 0x11C
	jmp	LBB1_108
LBB1_57:                                ## %.loopexit544
	movl	$285, %ebx                      ## imm = 0x11D
	jmp	LBB1_108
LBB1_58:                                ## %.loopexit545
	movl	$286, %ebx                      ## imm = 0x11E
	jmp	LBB1_108
LBB1_62:                                ## %.loopexit551
	movl	$287, %ebx                      ## imm = 0x11F
LBB1_108:                               ## %.loopexit522
	movl	%ebx, %eax
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB1_101:                               ## %.loopexit516
	leaq	L_.str.33(%rip), %rdi
	callq	_yy_fatal_error
LBB1_109:
	leaq	L_.str.34(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
	.p2align	2, 0x90
	.data_region jt32
.set L1_0_set_35, LBB1_35-LJTI1_0
.set L1_0_set_102, LBB1_102-LJTI1_0
.set L1_0_set_103, LBB1_103-LJTI1_0
.set L1_0_set_104, LBB1_104-LJTI1_0
.set L1_0_set_105, LBB1_105-LJTI1_0
.set L1_0_set_106, LBB1_106-LJTI1_0
.set L1_0_set_107, LBB1_107-LJTI1_0
.set L1_0_set_36, LBB1_36-LJTI1_0
.set L1_0_set_37, LBB1_37-LJTI1_0
.set L1_0_set_38, LBB1_38-LJTI1_0
.set L1_0_set_39, LBB1_39-LJTI1_0
.set L1_0_set_40, LBB1_40-LJTI1_0
.set L1_0_set_41, LBB1_41-LJTI1_0
.set L1_0_set_42, LBB1_42-LJTI1_0
.set L1_0_set_43, LBB1_43-LJTI1_0
.set L1_0_set_44, LBB1_44-LJTI1_0
.set L1_0_set_45, LBB1_45-LJTI1_0
.set L1_0_set_46, LBB1_46-LJTI1_0
.set L1_0_set_47, LBB1_47-LJTI1_0
.set L1_0_set_48, LBB1_48-LJTI1_0
.set L1_0_set_49, LBB1_49-LJTI1_0
.set L1_0_set_50, LBB1_50-LJTI1_0
.set L1_0_set_51, LBB1_51-LJTI1_0
.set L1_0_set_52, LBB1_52-LJTI1_0
.set L1_0_set_53, LBB1_53-LJTI1_0
.set L1_0_set_54, LBB1_54-LJTI1_0
.set L1_0_set_55, LBB1_55-LJTI1_0
.set L1_0_set_56, LBB1_56-LJTI1_0
.set L1_0_set_57, LBB1_57-LJTI1_0
.set L1_0_set_58, LBB1_58-LJTI1_0
.set L1_0_set_59, LBB1_59-LJTI1_0
.set L1_0_set_14, LBB1_14-LJTI1_0
.set L1_0_set_60, LBB1_60-LJTI1_0
.set L1_0_set_62, LBB1_62-LJTI1_0
.set L1_0_set_63, LBB1_63-LJTI1_0
.set L1_0_set_27, LBB1_27-LJTI1_0
.set L1_0_set_108, LBB1_108-LJTI1_0
LJTI1_0:
	.long	L1_0_set_35
	.long	L1_0_set_102
	.long	L1_0_set_103
	.long	L1_0_set_104
	.long	L1_0_set_105
	.long	L1_0_set_106
	.long	L1_0_set_107
	.long	L1_0_set_36
	.long	L1_0_set_37
	.long	L1_0_set_38
	.long	L1_0_set_39
	.long	L1_0_set_40
	.long	L1_0_set_41
	.long	L1_0_set_42
	.long	L1_0_set_43
	.long	L1_0_set_44
	.long	L1_0_set_45
	.long	L1_0_set_46
	.long	L1_0_set_47
	.long	L1_0_set_48
	.long	L1_0_set_49
	.long	L1_0_set_50
	.long	L1_0_set_51
	.long	L1_0_set_52
	.long	L1_0_set_53
	.long	L1_0_set_54
	.long	L1_0_set_55
	.long	L1_0_set_56
	.long	L1_0_set_57
	.long	L1_0_set_58
	.long	L1_0_set_59
	.long	L1_0_set_59
	.long	L1_0_set_59
	.long	L1_0_set_14
	.long	L1_0_set_60
	.long	L1_0_set_62
	.long	L1_0_set_63
	.long	L1_0_set_27
	.long	L1_0_set_108
	.end_data_region
                                        ## -- End function
	.globl	_yyerror                        ## -- Begin function yyerror
	.p2align	4, 0x90
_yyerror:                               ## @yyerror
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, %rdx
	movq	___stderrp@GOTPCREL(%rip), %rax
	movq	(%rax), %rdi
	movl	_linecounter(%rip), %ecx
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %r8
	leaq	L_.str.39(%rip), %rsi
	xorl	%eax, %eax
	callq	_fprintf
	movl	$1, %edi
	callq	_exit
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90                         ## -- Begin function yyensure_buffer_stack
_yyensure_buffer_stack:                 ## @yyensure_buffer_stack
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -24
	movq	_yy_buffer_stack(%rip), %rdi
	testq	%rdi, %rdi
	je	LBB3_1
## %bb.3:
	movq	_yy_buffer_stack_max(%rip), %rbx
	leaq	-1(%rbx), %rax
	cmpq	%rax, _yy_buffer_stack_top(%rip)
	jb	LBB3_6
## %bb.4:
	leaq	64(,%rbx,8), %rsi
	callq	_realloc
	movq	%rax, _yy_buffer_stack(%rip)
	testq	%rax, %rax
	je	LBB3_7
## %bb.5:
	leaq	8(%rbx), %rcx
	xorps	%xmm0, %xmm0
	movups	%xmm0, 48(%rax,%rbx,8)
	movups	%xmm0, 32(%rax,%rbx,8)
	movups	%xmm0, 16(%rax,%rbx,8)
	movups	%xmm0, (%rax,%rbx,8)
	movq	%rcx, _yy_buffer_stack_max(%rip)
	jmp	LBB3_6
LBB3_1:
	movl	$8, %edi
	callq	_malloc
	movq	%rax, _yy_buffer_stack(%rip)
	testq	%rax, %rax
	je	LBB3_7
## %bb.2:
	movq	$0, (%rax)
	movq	$1, _yy_buffer_stack_max(%rip)
	movq	$0, _yy_buffer_stack_top(%rip)
LBB3_6:
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	retq
LBB3_7:
	leaq	L_.str.45(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_create_buffer               ## -- Begin function yy_create_buffer
	.p2align	4, 0x90
_yy_create_buffer:                      ## @yy_create_buffer
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	%esi, %r15d
	movq	%rdi, %rbx
	movl	$72, %edi
	callq	_malloc
	testq	%rax, %rax
	je	LBB4_3
## %bb.1:
	movq	%rax, %r14
	movl	%r15d, 24(%rax)
	addl	$2, %r15d
	movslq	%r15d, %rdi
	callq	_malloc
	movq	%rax, 8(%r14)
	testq	%rax, %rax
	je	LBB4_3
## %bb.2:
	movl	$1, 40(%r14)
	movq	%r14, %rdi
	movq	%rbx, %rsi
	callq	_yy_init_buffer
	movq	%r14, %rax
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB4_3:
	leaq	L_.str.34(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_comment                        ## -- Begin function comment
	.p2align	4, 0x90
_comment:                               ## @comment
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movzbl	_yy_hold_char(%rip), %eax
	movq	_yy_c_buf_p(%rip), %rbx
	movb	%al, (%rbx)
	testb	%al, %al
	jne	LBB5_9
## %bb.1:
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	movq	8(%rax), %rax
	addq	_yy_n_chars(%rip), %rax
	cmpq	%rax, %rbx
	jae	LBB5_3
## %bb.2:
	movb	$0, (%rbx)
	jmp	LBB5_9
LBB5_3:
	movq	_yytext@GOTPCREL(%rip), %r14
	movq	(%r14), %r15
	leaq	1(%rbx), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	callq	_yy_get_next_buffer
	testl	%eax, %eax
	je	LBB5_8
## %bb.4:
	xorl	%r14d, %r14d
	cmpl	$1, %eax
	je	LBB5_10
## %bb.5:
	cmpl	$2, %eax
	jne	LBB5_6
## %bb.7:
	movq	_yyin(%rip), %rdi
	callq	_yyrestart
	jmp	LBB5_10
LBB5_8:
	subq	%r15, %rbx
	addq	(%r14), %rbx
	jmp	LBB5_9
LBB5_6:                                 ## %._crit_edge.i
	movq	_yy_c_buf_p(%rip), %rbx
LBB5_9:
	movzbl	(%rbx), %r14d
	movb	$0, (%rbx)
	leaq	1(%rbx), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	movzbl	1(%rbx), %eax
	movb	%al, _yy_hold_char(%rip)
LBB5_10:                                ## %input.exit.preheader
	movq	_yytext@GOTPCREL(%rip), %rbx
	jmp	LBB5_11
	.p2align	4, 0x90
LBB5_36:                                ##   in Loop: Header=BB5_11 Depth=1
	incl	_linecounter(%rip)
	movl	%r13d, %r14d
LBB5_11:                                ## %input.exit
                                        ## =>This Inner Loop Header: Depth=1
	movzbl	_yy_hold_char(%rip), %eax
	movq	_yy_c_buf_p(%rip), %r15
	movb	%al, (%r15)
	testb	%al, %al
	jne	LBB5_19
## %bb.12:                              ##   in Loop: Header=BB5_11 Depth=1
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	movq	8(%rax), %rax
	addq	_yy_n_chars(%rip), %rax
	cmpq	%rax, %r15
	jae	LBB5_14
## %bb.13:                              ##   in Loop: Header=BB5_11 Depth=1
	movb	$0, (%r15)
	jmp	LBB5_19
LBB5_14:                                ##   in Loop: Header=BB5_11 Depth=1
	movq	(%rbx), %r12
	leaq	1(%r15), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	callq	_yy_get_next_buffer
	testl	%eax, %eax
	je	LBB5_18
## %bb.15:                              ##   in Loop: Header=BB5_11 Depth=1
	xorl	%r13d, %r13d
	cmpl	$1, %eax
	je	LBB5_34
## %bb.16:                              ##   in Loop: Header=BB5_11 Depth=1
	cmpl	$2, %eax
	jne	LBB5_17
## %bb.33:                              ##   in Loop: Header=BB5_11 Depth=1
	movq	_yyin(%rip), %rdi
	callq	_yyrestart
	jmp	LBB5_34
LBB5_18:                                ##   in Loop: Header=BB5_11 Depth=1
	subq	%r12, %r15
	addq	(%rbx), %r15
	jmp	LBB5_19
LBB5_17:                                ## %._crit_edge.i18
                                        ##   in Loop: Header=BB5_11 Depth=1
	movq	_yy_c_buf_p(%rip), %r15
	.p2align	4, 0x90
LBB5_19:                                ## %input.exit20
                                        ##   in Loop: Header=BB5_11 Depth=1
	movzbl	(%r15), %ecx
	movb	$0, (%r15)
	leaq	1(%r15), %r12
	movq	%r12, _yy_c_buf_p(%rip)
	movzbl	1(%r15), %eax
	movb	%al, _yy_hold_char(%rip)
	cmpl	$42, %r14d
	jne	LBB5_21
## %bb.20:                              ## %input.exit20
                                        ##   in Loop: Header=BB5_11 Depth=1
	cmpb	$47, %cl
	je	LBB5_37
LBB5_21:                                ##   in Loop: Header=BB5_11 Depth=1
	movzbl	%cl, %r13d
	cmpl	$13, %r14d
	jne	LBB5_34
## %bb.22:                              ##   in Loop: Header=BB5_11 Depth=1
	cmpb	$10, %cl
	jne	LBB5_34
## %bb.23:                              ##   in Loop: Header=BB5_11 Depth=1
	incl	_linecounter(%rip)
	movb	%al, (%r12)
	testb	%al, %al
	jne	LBB5_32
## %bb.24:                              ##   in Loop: Header=BB5_11 Depth=1
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	movq	8(%rax), %rax
	addq	_yy_n_chars(%rip), %rax
	cmpq	%rax, %r12
	jae	LBB5_26
## %bb.25:                              ##   in Loop: Header=BB5_11 Depth=1
	movb	$0, (%r12)
	jmp	LBB5_32
	.p2align	4, 0x90
LBB5_34:                                ## %.thread
                                        ##   in Loop: Header=BB5_11 Depth=1
	cmpl	$13, %r14d
	je	LBB5_36
## %bb.35:                              ## %.thread
                                        ##   in Loop: Header=BB5_11 Depth=1
	cmpl	$10, %r14d
	movl	%r13d, %r14d
	je	LBB5_36
	jmp	LBB5_11
LBB5_26:                                ##   in Loop: Header=BB5_11 Depth=1
	movq	(%rbx), %r14
	addq	$2, %r15
	movq	%r15, _yy_c_buf_p(%rip)
	callq	_yy_get_next_buffer
	testl	%eax, %eax
	je	LBB5_31
## %bb.27:                              ##   in Loop: Header=BB5_11 Depth=1
	xorl	%r14d, %r14d
	cmpl	$1, %eax
	je	LBB5_11
## %bb.28:                              ##   in Loop: Header=BB5_11 Depth=1
	cmpl	$2, %eax
	jne	LBB5_29
## %bb.30:                              ##   in Loop: Header=BB5_11 Depth=1
	movq	_yyin(%rip), %rdi
	callq	_yyrestart
	jmp	LBB5_11
LBB5_31:                                ##   in Loop: Header=BB5_11 Depth=1
	subq	%r14, %r12
	addq	(%rbx), %r12
	jmp	LBB5_32
LBB5_29:                                ## %._crit_edge.i22
                                        ##   in Loop: Header=BB5_11 Depth=1
	movq	_yy_c_buf_p(%rip), %r12
	.p2align	4, 0x90
LBB5_32:                                ##   in Loop: Header=BB5_11 Depth=1
	movzbl	(%r12), %r14d
	movb	$0, (%r12)
	leaq	1(%r12), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	movzbl	1(%r12), %eax
	movb	%al, _yy_hold_char(%rip)
	jmp	LBB5_11
LBB5_37:
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90                         ## -- Begin function yy_get_next_buffer
_yy_get_next_buffer:                    ## @yy_get_next_buffer
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$24, %rsp
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	%rax, -48(%rbp)                 ## 8-byte Spill
	movq	(%rax,%r15,8), %r13
	movq	8(%r13), %rdx
	movq	_yy_c_buf_p(%rip), %r12
	movq	_yy_n_chars(%rip), %rax
	addq	%rdx, %rax
	incq	%rax
	cmpq	%rax, %r12
	ja	LBB6_56
## %bb.1:
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	cmpl	$0, 60(%r13)
	je	LBB6_7
## %bb.2:
	movq	%rax, %rcx
	notq	%rcx
	addq	%r12, %rcx
	movq	%rcx, -56(%rbp)                 ## 8-byte Spill
	testl	%ecx, %ecx
	jle	LBB6_20
## %bb.3:                               ## %iter.check
	movl	%r12d, %esi
	subl	%eax, %esi
	addl	$-2, %esi
	xorl	%ecx, %ecx
	cmpl	$7, %esi
	jb	LBB6_8
## %bb.4:                               ## %iter.check
	movq	%rdx, %rdi
	subq	%rax, %rdi
	cmpq	$32, %rdi
	jb	LBB6_8
## %bb.5:                               ## %vector.main.loop.iter.check
	leaq	1(%rsi), %r8
	movabsq	$8589934560, %rcx               ## imm = 0x1FFFFFFE0
	cmpl	$31, %esi
	jae	LBB6_9
## %bb.6:
	xorl	%r9d, %r9d
	jmp	LBB6_13
LBB6_7:
	subq	%rax, %r12
	xorl	%r14d, %r14d
	cmpq	$1, %r12
	setne	%r14b
	incl	%r14d
	jmp	LBB6_53
LBB6_8:
	movq	%rdx, %rsi
	movq	%rax, %rdi
	jmp	LBB6_17
LBB6_9:                                 ## %vector.ph
	movq	%r8, %r9
	andq	%rcx, %r9
	xorl	%esi, %esi
	.p2align	4, 0x90
LBB6_10:                                ## %vector.body
                                        ## =>This Inner Loop Header: Depth=1
	movups	(%rax,%rsi), %xmm0
	movups	16(%rax,%rsi), %xmm1
	movups	%xmm0, (%rdx,%rsi)
	movups	%xmm1, 16(%rdx,%rsi)
	addq	$32, %rsi
	cmpq	%rsi, %r9
	jne	LBB6_10
## %bb.11:                              ## %middle.block
	cmpq	%r9, %r8
	je	LBB6_19
## %bb.12:                              ## %vec.epilog.iter.check
	testb	$24, %r8b
	je	LBB6_16
LBB6_13:                                ## %vec.epilog.ph
	addq	$24, %rcx
	andq	%r8, %rcx
	leaq	(%rdx,%rcx), %rsi
	leaq	(%rax,%rcx), %rdi
	.p2align	4, 0x90
LBB6_14:                                ## %vec.epilog.vector.body
                                        ## =>This Inner Loop Header: Depth=1
	movq	(%rax,%r9), %r10
	movq	%r10, (%rdx,%r9)
	addq	$8, %r9
	cmpq	%r9, %rcx
	jne	LBB6_14
## %bb.15:                              ## %vec.epilog.middle.block
	cmpq	%rcx, %r8
	jne	LBB6_17
	jmp	LBB6_19
LBB6_16:
	leaq	(%rax,%r9), %rdi
	addq	%r9, %rdx
	movq	%rdx, %rsi
	movl	%r9d, %ecx
LBB6_17:                                ## %.lr.ph.preheader
	notl	%ecx
	addl	%r12d, %ecx
	subl	%eax, %ecx
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB6_18:                                ## %.lr.ph
                                        ## =>This Inner Loop Header: Depth=1
	movzbl	(%rdi,%rax), %edx
	movb	%dl, (%rsi,%rax)
	incq	%rax
	cmpl	%eax, %ecx
	jne	LBB6_18
LBB6_19:                                ## %._crit_edge.loopexit
	movq	-48(%rbp), %rax                 ## 8-byte Reload
	movq	(%rax,%r15,8), %r13
LBB6_20:                                ## %._crit_edge
	cmpl	$2, 64(%r13)
	jne	LBB6_23
## %bb.21:                              ## %.thread78
	movq	$0, _yy_n_chars(%rip)
	movq	-56(%rbp), %r12                 ## 8-byte Reload
LBB6_22:                                ## %.thread78
	movq	$0, 32(%r13)
	testl	%r12d, %r12d
	jne	LBB6_45
LBB6_47:
	movq	_yyin(%rip), %rdi
	callq	_yyrestart
	movq	_yy_n_chars(%rip), %rbx
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	%rax, -48(%rbp)                 ## 8-byte Spill
	movq	(%rax,%r15,8), %r13
	movl	$1, %r14d
	jmp	LBB6_48
LBB6_23:
	movq	-56(%rbp), %rax                 ## 8-byte Reload
	movl	%eax, %r14d
	notl	%r14d
	movl	24(%r13), %ecx
	movl	%ecx, %edx
	addl	%r14d, %edx
	jne	LBB6_27
	.p2align	4, 0x90
LBB6_24:                                ## %.lr.ph91
                                        ## =>This Inner Loop Header: Depth=1
	cmpl	$0, 40(%r13)
	je	LBB6_54
## %bb.25:                              ##   in Loop: Header=BB6_24 Depth=1
	movq	8(%r13), %rbx
	leal	(%rcx,%rcx), %eax
	movl	%eax, 24(%r13)
	leal	2(,%rcx,2), %eax
	movslq	%eax, %rsi
	movq	%rbx, %rdi
	callq	_realloc
	movq	%rax, 8(%r13)
	testq	%rax, %rax
	je	LBB6_55
## %bb.26:                              ##   in Loop: Header=BB6_24 Depth=1
	subq	%rbx, %r12
	movslq	%r12d, %rcx
	addq	%rcx, %rax
	movq	%rax, _yy_c_buf_p(%rip)
	movq	-48(%rbp), %rcx                 ## 8-byte Reload
	movq	(%rcx,%r15,8), %r13
	movl	24(%r13), %ecx
	movl	%ecx, %edx
	movq	%rax, %r12
	addl	%r14d, %edx
	je	LBB6_24
LBB6_27:                                ## %._crit_edge92
	cmpl	$8192, %edx                     ## imm = 0x2000
	movl	$8192, %r14d                    ## imm = 0x2000
	cmovbl	%edx, %r14d
	cmpl	$0, 44(%r13)
	je	LBB6_36
## %bb.28:                              ## %.lr.ph94
	movq	-56(%rbp), %r12                 ## 8-byte Reload
	movslq	%r12d, %r15
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB6_29:                                ## =>This Inner Loop Header: Depth=1
	movq	_yyin(%rip), %rdi
	callq	_getc
	cmpl	$-1, %eax
	je	LBB6_33
## %bb.30:                              ##   in Loop: Header=BB6_29 Depth=1
	cmpl	$10, %eax
	je	LBB6_33
## %bb.31:                              ##   in Loop: Header=BB6_29 Depth=1
	movq	_yy_buffer_stack(%rip), %rcx
	movq	_yy_buffer_stack_top(%rip), %rdx
	movq	(%rcx,%rdx,8), %rcx
	movq	8(%rcx), %rcx
	addq	%r15, %rcx
	movb	%al, (%rbx,%rcx)
	incq	%rbx
	cmpq	%rbx, %r14
	jne	LBB6_29
## %bb.32:
	movq	%r14, %rbx
LBB6_33:                                ## %.critedge
	cmpl	$-1, %eax
	je	LBB6_41
## %bb.34:                              ## %.critedge
	cmpl	$10, %eax
	jne	LBB6_42
## %bb.35:                              ## %.thread75
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	addq	8(%rax), %r15
	movb	$10, (%rbx,%r15)
	incq	%rbx
	jmp	LBB6_42
LBB6_36:
	callq	___error
	movl	$0, (%rax)
	movq	-56(%rbp), %r12                 ## 8-byte Reload
	movslq	%r12d, %r15
	.p2align	4, 0x90
LBB6_37:                                ## =>This Inner Loop Header: Depth=1
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	movq	8(%rax), %rdi
	addq	%r15, %rdi
	movq	_yyin(%rip), %rcx
	movl	$1, %esi
	movq	%r14, %rdx
	callq	_fread
	movslq	%eax, %rbx
	shlq	$32, %rax
	movq	%rbx, _yy_n_chars(%rip)
	jne	LBB6_43
## %bb.38:                              ## %.lr.ph105
                                        ##   in Loop: Header=BB6_37 Depth=1
	movq	_yyin(%rip), %rdi
	callq	_ferror
	testl	%eax, %eax
	je	LBB6_46
## %bb.39:                              ##   in Loop: Header=BB6_37 Depth=1
	callq	___error
	cmpl	$4, (%rax)
	jne	LBB6_57
## %bb.40:                              ##   in Loop: Header=BB6_37 Depth=1
	callq	___error
	movl	$0, (%rax)
	movq	_yyin(%rip), %rdi
	callq	_clearerr
	jmp	LBB6_37
LBB6_41:
	movq	_yyin(%rip), %rdi
	callq	_ferror
	testl	%eax, %eax
	jne	LBB6_57
LBB6_42:
	movq	%rbx, _yy_n_chars(%rip)
LBB6_43:                                ## %.loopexit
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	%rax, -48(%rbp)                 ## 8-byte Spill
	movq	(%rax,%r15,8), %r13
	movq	%rbx, 32(%r13)
	xorl	%r14d, %r14d
	testq	%rbx, %rbx
	jne	LBB6_48
## %bb.44:
	testl	%r12d, %r12d
	je	LBB6_47
LBB6_45:
	movl	$2, 64(%r13)
	movl	$2, %r14d
	xorl	%ebx, %ebx
LBB6_48:
	movslq	%r12d, %r12
	addq	%rbx, %r12
	movslq	24(%r13), %rax
	cmpq	%rax, %r12
	jbe	LBB6_51
## %bb.49:
	shrq	%rbx
	addq	%r12, %rbx
	movq	8(%r13), %rdi
	movq	%rbx, %rsi
	callq	_realloc
	movq	-48(%rbp), %rdx                 ## 8-byte Reload
	movq	(%rdx,%r15,8), %rcx
	movq	%rax, 8(%rcx)
	movq	(%rdx,%r15,8), %rcx
	movq	8(%rcx), %rax
	testq	%rax, %rax
	je	LBB6_58
## %bb.50:
	addl	$-2, %ebx
	movl	%ebx, 24(%rcx)
	jmp	LBB6_52
LBB6_51:                                ## %._crit_edge117
	movq	8(%r13), %rax
LBB6_52:
	movq	%r12, _yy_n_chars(%rip)
	movb	$0, (%rax,%r12)
	movq	-48(%rbp), %rcx                 ## 8-byte Reload
	movq	(%rcx,%r15,8), %rax
	movq	8(%rax), %rax
	movb	$0, 1(%r12,%rax)
	movq	(%rcx,%r15,8), %rax
	movq	8(%rax), %rax
	movq	_yytext@GOTPCREL(%rip), %rcx
	movq	%rax, (%rcx)
LBB6_53:
	movl	%r14d, %eax
	addq	$24, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB6_46:                                ## %.loopexit.thread
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	%rax, -48(%rbp)                 ## 8-byte Spill
	movq	(%rax,%r15,8), %r13
	jmp	LBB6_22
LBB6_54:                                ## %.thread
	movq	$0, 8(%r13)
LBB6_55:                                ## %.loopexit80
	leaq	L_.str.42(%rip), %rdi
	callq	_yy_fatal_error
LBB6_56:
	leaq	L_.str.41(%rip), %rdi
	callq	_yy_fatal_error
LBB6_57:
	leaq	L_.str.43(%rip), %rdi
	callq	_yy_fatal_error
LBB6_58:
	leaq	L_.str.44(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_yywrap                         ## -- Begin function yywrap
	.p2align	4, 0x90
_yywrap:                                ## @yywrap
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	$1, %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyrestart                      ## -- Begin function yyrestart
	.p2align	4, 0x90
_yyrestart:                             ## @yyrestart
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	%rdi, %rbx
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rax, %rax
	je	LBB8_2
## %bb.1:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %r14
	testq	%r14, %r14
	jne	LBB8_5
LBB8_2:
	callq	_yyensure_buffer_stack
	movq	_yyin(%rip), %r15
	movl	$72, %edi
	callq	_malloc
	testq	%rax, %rax
	je	LBB8_6
## %bb.3:
	movq	%rax, %r14
	movl	$16384, 24(%rax)                ## imm = 0x4000
	movl	$16386, %edi                    ## imm = 0x4002
	callq	_malloc
	movq	%rax, 8(%r14)
	testq	%rax, %rax
	je	LBB8_6
## %bb.4:                               ## %.thread
	movl	$1, 40(%r14)
	movq	%r14, %rdi
	movq	%r15, %rsi
	callq	_yy_init_buffer
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	%r14, (%rax,%rcx,8)
LBB8_5:
	movq	%r14, %rdi
	movq	%rbx, %rsi
	callq	_yy_init_buffer
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rdx
	movq	32(%rdx), %rsi
	movq	%rsi, _yy_n_chars(%rip)
	movq	16(%rdx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%rdx), %eax
	movb	%al, _yy_hold_char(%rip)
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB8_6:
	leaq	L_.str.34(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90                         ## -- Begin function yy_fatal_error
_yy_fatal_error:                        ## @yy_fatal_error
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, %rdx
	movq	___stderrp@GOTPCREL(%rip), %rax
	movq	(%rax), %rdi
	leaq	L_.str.46(%rip), %rsi
	xorl	%eax, %eax
	callq	_fprintf
	movl	$2, %edi
	callq	_exit
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90                         ## -- Begin function yy_init_buffer
_yy_init_buffer:                        ## @yy_init_buffer
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	%rsi, %r14
	movq	%rdi, %rbx
	callq	___error
	movl	(%rax), %r15d
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rbx, %rbx
	je	LBB10_7
## %bb.1:
	movq	$0, 32(%rbx)
	movq	8(%rbx), %rcx
	movb	$0, (%rcx)
	movq	8(%rbx), %rcx
	movb	$0, 1(%rcx)
	movq	8(%rbx), %rcx
	movq	%rcx, 16(%rbx)
	movl	$1, 48(%rbx)
	movl	$0, 64(%rbx)
	testq	%rax, %rax
	je	LBB10_2
## %bb.3:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rcx
	cmpq	%rbx, %rcx
	je	LBB10_5
LBB10_7:                                ## %yy_flush_buffer.exit
	movq	%r14, (%rbx)
	movl	$1, 60(%rbx)
	testq	%rax, %rax
	jne	LBB10_6
## %bb.8:
	xorl	%eax, %eax
	cmpq	%rbx, %rax
	jne	LBB10_10
	jmp	LBB10_11
LBB10_2:
	xorl	%ecx, %ecx
	cmpq	%rbx, %rcx
	jne	LBB10_7
LBB10_5:                                ## %yy_flush_buffer.exit.thread
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rdx
	movq	32(%rdx), %rsi
	movq	%rsi, _yy_n_chars(%rip)
	movq	16(%rdx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rcx
	movq	(%rcx), %rcx
	movq	%rcx, _yyin(%rip)
	movzbl	(%rdx), %ecx
	movb	%cl, _yy_hold_char(%rip)
	movq	%r14, (%rbx)
	movl	$1, 60(%rbx)
LBB10_6:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rax
	cmpq	%rbx, %rax
	je	LBB10_11
LBB10_10:
	movq	$1, 52(%rbx)
LBB10_11:
	testq	%r14, %r14
	je	LBB10_12
## %bb.13:
	movq	%r14, %rdi
	callq	_fileno
	movl	%eax, %edi
	callq	_isatty
	xorl	%ecx, %ecx
	testl	%eax, %eax
	setg	%cl
	jmp	LBB10_14
LBB10_12:
	xorl	%ecx, %ecx
LBB10_14:
	movl	%ecx, 44(%rbx)
	callq	___error
	movl	%r15d, (%rax)
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_switch_to_buffer            ## -- Begin function yy_switch_to_buffer
	.p2align	4, 0x90
_yy_switch_to_buffer:                   ## @yy_switch_to_buffer
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -24
	movq	%rdi, %rbx
	callq	_yyensure_buffer_stack
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rax, %rax
	je	LBB11_1
## %bb.3:                               ## %.thread
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rdx
	cmpq	%rbx, %rdx
	je	LBB11_7
## %bb.4:
	testq	%rdx, %rdx
	je	LBB11_6
## %bb.5:
	movzbl	_yy_hold_char(%rip), %edx
	movq	_yy_c_buf_p(%rip), %rsi
	movb	%dl, (%rsi)
	movq	(%rax,%rcx,8), %rdx
	movq	%rsi, 16(%rdx)
	movq	_yy_n_chars(%rip), %rdx
	movq	(%rax,%rcx,8), %rsi
	movq	%rdx, 32(%rsi)
	jmp	LBB11_6
LBB11_1:
	testq	%rbx, %rbx
	je	LBB11_7
## %bb.2:                               ## %._crit_edge
	movq	_yy_buffer_stack_top(%rip), %rcx
LBB11_6:
	movq	%rbx, (%rax,%rcx,8)
	movq	32(%rbx), %rdx
	movq	%rdx, _yy_n_chars(%rip)
	movq	16(%rbx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%rdx), %eax
	movb	%al, _yy_hold_char(%rip)
LBB11_7:
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyalloc                        ## -- Begin function yyalloc
	.p2align	4, 0x90
_yyalloc:                               ## @yyalloc
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	jmp	_malloc                         ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_delete_buffer               ## -- Begin function yy_delete_buffer
	.p2align	4, 0x90
_yy_delete_buffer:                      ## @yy_delete_buffer
	.cfi_startproc
## %bb.0:
	testq	%rdi, %rdi
	je	LBB13_9
## %bb.1:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -24
	movq	%rdi, %rbx
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rax, %rax
	je	LBB13_2
## %bb.3:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rcx
	cmpq	%rbx, %rcx
	jne	LBB13_6
LBB13_5:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	$0, (%rax,%rcx,8)
LBB13_6:
	cmpl	$0, 40(%rbx)
	je	LBB13_8
## %bb.7:
	movq	8(%rbx), %rdi
	callq	_free
LBB13_8:
	movq	%rbx, %rdi
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	jmp	_free                           ## TAILCALL
LBB13_9:
	retq
LBB13_2:
	xorl	%ecx, %ecx
	cmpq	%rbx, %rcx
	jne	LBB13_6
	jmp	LBB13_5
	.cfi_endproc
                                        ## -- End function
	.globl	_yyfree                         ## -- Begin function yyfree
	.p2align	4, 0x90
_yyfree:                                ## @yyfree
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	jmp	_free                           ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_flush_buffer                ## -- Begin function yy_flush_buffer
	.p2align	4, 0x90
_yy_flush_buffer:                       ## @yy_flush_buffer
	.cfi_startproc
## %bb.0:
	testq	%rdi, %rdi
	je	LBB15_7
## %bb.1:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	$0, 32(%rdi)
	movq	8(%rdi), %rax
	movb	$0, (%rax)
	movq	8(%rdi), %rax
	movb	$0, 1(%rax)
	movq	8(%rdi), %rax
	movq	%rax, 16(%rdi)
	movl	$1, 48(%rdi)
	movl	$0, 64(%rdi)
	movq	_yy_buffer_stack(%rip), %rax
	testq	%rax, %rax
	je	LBB15_2
## %bb.3:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rcx
	cmpq	%rdi, %rcx
	jne	LBB15_6
LBB15_5:
	movq	_yy_buffer_stack_top(%rip), %rcx
	movq	(%rax,%rcx,8), %rdx
	movq	32(%rdx), %rsi
	movq	%rsi, _yy_n_chars(%rip)
	movq	16(%rdx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%rdx), %eax
	movb	%al, _yy_hold_char(%rip)
LBB15_6:
	popq	%rbp
LBB15_7:
	retq
LBB15_2:
	xorl	%ecx, %ecx
	cmpq	%rdi, %rcx
	jne	LBB15_6
	jmp	LBB15_5
	.cfi_endproc
                                        ## -- End function
	.globl	_yypush_buffer_state            ## -- Begin function yypush_buffer_state
	.p2align	4, 0x90
_yypush_buffer_state:                   ## @yypush_buffer_state
	.cfi_startproc
## %bb.0:
	testq	%rdi, %rdi
	je	LBB16_5
## %bb.1:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -24
	movq	%rdi, %rbx
	callq	_yyensure_buffer_stack
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	testq	%rax, %rax
	je	LBB16_4
## %bb.2:
	cmpq	$0, (%rax,%rcx,8)
	je	LBB16_4
## %bb.3:
	movzbl	_yy_hold_char(%rip), %edx
	movq	_yy_c_buf_p(%rip), %rsi
	movb	%dl, (%rsi)
	movq	(%rax,%rcx,8), %rdx
	movq	%rsi, 16(%rdx)
	movq	_yy_n_chars(%rip), %rdx
	movq	(%rax,%rcx,8), %rsi
	movq	%rdx, 32(%rsi)
	incq	%rcx
	movq	%rcx, _yy_buffer_stack_top(%rip)
LBB16_4:                                ## %.thread
	movq	%rbx, (%rax,%rcx,8)
	movq	32(%rbx), %rdx
	movq	%rdx, _yy_n_chars(%rip)
	movq	16(%rbx), %rdx
	movq	%rdx, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rsi
	movq	%rdx, (%rsi)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%rdx), %eax
	movb	%al, _yy_hold_char(%rip)
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
LBB16_5:
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yypop_buffer_state             ## -- Begin function yypop_buffer_state
	.p2align	4, 0x90
_yypop_buffer_state:                    ## @yypop_buffer_state
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	_yy_buffer_stack(%rip), %r14
	testq	%r14, %r14
	je	LBB17_7
## %bb.1:
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	(%r14,%r15,8), %rbx
	testq	%rbx, %rbx
	je	LBB17_7
## %bb.2:
	movq	$0, (%r14,%r15,8)
	cmpl	$0, 40(%rbx)
	je	LBB17_4
## %bb.3:
	movq	8(%rbx), %rdi
	callq	_free
LBB17_4:                                ## %yy_delete_buffer.exit
	movq	%rbx, %rdi
	callq	_free
	movq	$0, (%r14,%r15,8)
	testq	%r15, %r15
	je	LBB17_7
## %bb.5:
	leaq	-1(%r15), %rax
	movq	%rax, _yy_buffer_stack_top(%rip)
	movq	-8(%r14,%r15,8), %rax
	testq	%rax, %rax
	je	LBB17_7
## %bb.6:
	movq	32(%rax), %rcx
	movq	%rcx, _yy_n_chars(%rip)
	movq	16(%rax), %rax
	movq	%rax, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rcx
	movq	%rax, (%rcx)
	movq	-8(%r14,%r15,8), %rcx
	movq	(%rcx), %rcx
	movq	%rcx, _yyin(%rip)
	movzbl	(%rax), %eax
	movb	%al, _yy_hold_char(%rip)
LBB17_7:                                ## %.thread
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_scan_buffer                 ## -- Begin function yy_scan_buffer
	.p2align	4, 0x90
_yy_scan_buffer:                        ## @yy_scan_buffer
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	cmpq	$2, %rsi
	jb	LBB18_1
## %bb.2:
	movq	%rsi, %r15
	movq	%rdi, %r14
	cmpb	$0, -2(%rdi,%rsi)
	jne	LBB18_1
## %bb.4:
	cmpb	$0, -1(%r15,%r14)
	je	LBB18_6
LBB18_1:
	xorl	%ebx, %ebx
LBB18_12:                               ## %yy_switch_to_buffer.exit
	movq	%rbx, %rax
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB18_6:
	movl	$72, %edi
	callq	_malloc
	testq	%rax, %rax
	je	LBB18_13
## %bb.7:
	movq	%rax, %rbx
	addq	$-2, %r15
	movl	%r15d, 24(%rax)
	movq	%r14, 8(%rax)
	movq	%r14, 16(%rax)
	movl	$0, 40(%rax)
	movq	$0, (%rax)
	movslq	%r15d, %r15
	movq	%r15, 32(%rax)
	movabsq	$4294967296, %rax               ## imm = 0x100000000
	movq	%rax, 44(%rbx)
	movq	$0, 60(%rbx)
	callq	_yyensure_buffer_stack
	movq	_yy_buffer_stack(%rip), %rax
	movq	_yy_buffer_stack_top(%rip), %rcx
	testq	%rax, %rax
	je	LBB18_11
## %bb.8:                               ## %.thread.i
	movq	(%rax,%rcx,8), %rdx
	cmpq	%rbx, %rdx
	je	LBB18_12
## %bb.9:
	testq	%rdx, %rdx
	je	LBB18_11
## %bb.10:
	movzbl	_yy_hold_char(%rip), %edx
	movq	_yy_c_buf_p(%rip), %rsi
	movb	%dl, (%rsi)
	movq	(%rax,%rcx,8), %rdx
	movq	%rsi, 16(%rdx)
	movq	_yy_n_chars(%rip), %rdx
	movq	(%rax,%rcx,8), %rsi
	movq	%rdx, 32(%rsi)
	movq	16(%rbx), %r14
	movq	32(%rbx), %r15
LBB18_11:                               ## %._crit_edge.i
	movq	%rbx, (%rax,%rcx,8)
	movq	%r15, _yy_n_chars(%rip)
	movq	%r14, _yy_c_buf_p(%rip)
	movq	_yytext@GOTPCREL(%rip), %rdx
	movq	%r14, (%rdx)
	movq	(%rax,%rcx,8), %rax
	movq	(%rax), %rax
	movq	%rax, _yyin(%rip)
	movzbl	(%r14), %eax
	movb	%al, _yy_hold_char(%rip)
	jmp	LBB18_12
LBB18_13:
	leaq	L_.str.35(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_scan_string                 ## -- Begin function yy_scan_string
	.p2align	4, 0x90
_yy_scan_string:                        ## @yy_scan_string
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	%rdi, %r14
	callq	_strlen
	movq	%rax, %r13
	movslq	%r13d, %r15
	leaq	2(%r15), %rbx
	movq	%rbx, %rdi
	callq	_malloc
	testq	%rax, %rax
	je	LBB19_5
## %bb.1:                               ## %.preheader.i
	movq	%rax, %r12
	shlq	$32, %r13
	je	LBB19_3
## %bb.2:                               ## %.lr.ph.preheader.i
	movq	%r12, %rdi
	movq	%r14, %rsi
	movq	%r15, %rdx
	callq	_memcpy
LBB19_3:                                ## %._crit_edge.i
	movw	$0, (%r12,%r15)
	movq	%r12, %rdi
	movq	%rbx, %rsi
	callq	_yy_scan_buffer
	testq	%rax, %rax
	je	LBB19_6
## %bb.4:                               ## %yy_scan_bytes.exit
	movl	$1, 40(%rax)
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB19_5:
	leaq	L_.str.36(%rip), %rdi
	callq	_yy_fatal_error
LBB19_6:
	leaq	L_.str.37(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_yy_scan_bytes                  ## -- Begin function yy_scan_bytes
	.p2align	4, 0x90
_yy_scan_bytes:                         ## @yy_scan_bytes
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r12
	pushq	%rbx
	.cfi_offset %rbx, -48
	.cfi_offset %r12, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	%rsi, %r14
	movq	%rdi, %r12
	leaq	2(%rsi), %rbx
	movq	%rbx, %rdi
	callq	_malloc
	testq	%rax, %rax
	je	LBB20_5
## %bb.1:                               ## %.preheader
	movq	%rax, %r15
	testq	%r14, %r14
	je	LBB20_3
## %bb.2:                               ## %.lr.ph.preheader
	movq	%r15, %rdi
	movq	%r12, %rsi
	movq	%r14, %rdx
	callq	_memcpy
LBB20_3:                                ## %._crit_edge
	movw	$0, (%r15,%r14)
	movq	%r15, %rdi
	movq	%rbx, %rsi
	callq	_yy_scan_buffer
	testq	%rax, %rax
	je	LBB20_6
## %bb.4:
	movl	$1, 40(%rax)
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB20_5:
	leaq	L_.str.36(%rip), %rdi
	callq	_yy_fatal_error
LBB20_6:
	leaq	L_.str.37(%rip), %rdi
	callq	_yy_fatal_error
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_lineno                   ## -- Begin function yyget_lineno
	.p2align	4, 0x90
_yyget_lineno:                          ## @yyget_lineno
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	_yylineno(%rip), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_in                       ## -- Begin function yyget_in
	.p2align	4, 0x90
_yyget_in:                              ## @yyget_in
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	_yyin(%rip), %rax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_out                      ## -- Begin function yyget_out
	.p2align	4, 0x90
_yyget_out:                             ## @yyget_out
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	_yyout(%rip), %rax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_leng                     ## -- Begin function yyget_leng
	.p2align	4, 0x90
_yyget_leng:                            ## @yyget_leng
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	_yyleng@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_text                     ## -- Begin function yyget_text
	.p2align	4, 0x90
_yyget_text:                            ## @yyget_text
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	_yytext@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyset_lineno                   ## -- Begin function yyset_lineno
	.p2align	4, 0x90
_yyset_lineno:                          ## @yyset_lineno
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%edi, _yylineno(%rip)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyset_in                       ## -- Begin function yyset_in
	.p2align	4, 0x90
_yyset_in:                              ## @yyset_in
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, _yyin(%rip)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyset_out                      ## -- Begin function yyset_out
	.p2align	4, 0x90
_yyset_out:                             ## @yyset_out
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, _yyout(%rip)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyget_debug                    ## -- Begin function yyget_debug
	.p2align	4, 0x90
_yyget_debug:                           ## @yyget_debug
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	_yy_flex_debug(%rip), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyset_debug                    ## -- Begin function yyset_debug
	.p2align	4, 0x90
_yyset_debug:                           ## @yyset_debug
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%edi, _yy_flex_debug(%rip)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yylex_destroy                  ## -- Begin function yylex_destroy
	.p2align	4, 0x90
_yylex_destroy:                         ## @yylex_destroy
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	_yy_buffer_stack(%rip), %rbx
	testq	%rbx, %rbx
	je	LBB31_1
## %bb.2:                               ## %.lr.ph.preheader
	movq	_yy_buffer_stack_top(%rip), %r15
	movq	(%rbx,%r15,8), %r14
	testq	%r14, %r14
	je	LBB31_6
## %bb.3:                               ## %.lr.ph22
	movq	$0, (%rbx,%r15,8)
	cmpl	$0, 40(%r14)
	je	LBB31_5
## %bb.4:
	movq	8(%r14), %rdi
	callq	_free
	movq	_yy_buffer_stack(%rip), %rbx
	movq	_yy_buffer_stack_top(%rip), %r15
LBB31_5:                                ## %yypop_buffer_state.exit
	movq	%r14, %rdi
	callq	_free
	movq	$0, (%rbx,%r15,8)
	jmp	LBB31_6
LBB31_1:
	xorl	%ebx, %ebx
LBB31_6:                                ## %.thread
	movq	%rbx, %rdi
	callq	_free
	movq	$0, _yy_buffer_stack(%rip)
	movq	$0, _yy_buffer_stack_top(%rip)
	movq	$0, _yy_buffer_stack_max(%rip)
	movq	$0, _yy_c_buf_p(%rip)
	movb	$0, _yy_init(%rip)
	movb	$0, _yy_start(%rip)
	movq	$0, _yyin(%rip)
	movq	$0, _yyout(%rip)
	xorl	%eax, %eax
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_yyrealloc                      ## -- Begin function yyrealloc
	.p2align	4, 0x90
_yyrealloc:                             ## @yyrealloc
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	popq	%rbp
	jmp	_realloc                        ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.comm	_yynerrs,4,2                    ## @yynerrs
	.comm	_yychar,4,2                     ## @yychar
	.section	__TEXT,__const
	.p2align	4, 0x0                          ## @yypact
_yypact:
	.ascii	"6\314\001\0176\314\016\020<\376\314\314\314\314\0014U\314\314\314\314*W\377\314\314\314\314R\314\314\314\314\013^35D\001\001^^+++++++++++\025\f+\314J1\314\314\314@\314\314+\314\314U\314\314\314+YYYYYY\377\377\314\314\370\372+20\314Y)Y\025\025\025\025^\314YF\314\314FS2\314\31411\314\314\314\001\314\000\314"

	.p2align	4, 0x0                          ## @yytranslate
_yytranslate:
	.ascii	"\000\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\002\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 "

	.p2align	4, 0x0                          ## @yycheck
_yycheck:
	.ascii	"\016\016\"6\000\004\005\006\004\t\022\023\022\023\003\000\004\005\006\024\032\026\036\031\003\013\031\013\034*+,-./V\031\031\0334\03567\037()\031\004\005\006\035\nAh\004\005\006\003\nH\t\t\b\n`\027\030\007\031\024\025\036UV\n\031\034\032\n\032\f\r\016\017\020\021\022\023\022\023\032h\022\023\032\n\032\003p\f\r\016\017\020\021\022\023\022\023\\]\035^_\037()01\004523'&\377\3777"

	.p2align	4, 0x0                          ## @yytable
_yytable:
	.ascii	"#%?X\t\013\f\r\t&01\\]\001\035\013\f\r2e3d\"\001\037\016 sIJKLMNg5U6S7Y[V\t\t5\013\f\r7Abq\013\f\r\001hc&&\002Ao()!H^_jfY`Ui@\324B*+,-./0101aY\\]C'C\001r*+,-./0101kl4mnpFGOP\036TQRED\000\000Z"

	.comm	_yylval,8,3                     ## @yylval
	.p2align	4, 0x0                          ## @yydefact
_yydefact:
	.ascii	"\000?\000\000\002\003\000\000\000\"8@<=\000\t\026\030\032\034\033\000*034659\001\004\005\006\000\000\000\000*\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\007\b\016\021\023\022\000:\035\000+7\027\031 !\000\036\037$%&'./12\000\000\000\000\000(*\000,\000\000\000\000\000#-\000>\024,\000\000\013\025\f\r\017\020;\000)\000\n"

	.p2align	4, 0x0                          ## @yyr2
_yyr2:
	.ascii	"\000\002\001\001\002\002\002\003\003\002\006\003\003\003\001\003\003\001\001\001\003\003\001\003\001\003\001\001\001\003\003\003\003\003\001\004\003\003\003\003\001\003\001\003\001\003\003\003\001\003\003\001\001\001\001\003\001\001\001\003\001\001\004\001\001"

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"ASSERT"

L_.str.1:                               ## @.str.1
	.asciz	"PROVE"

L_.str.2:                               ## @.str.2
	.asciz	"INTENSION"

L_.str.3:                               ## @.str.3
	.asciz	"EXTENSION"

L_.str.4:                               ## @.str.4
	.asciz	"+"

L_.str.5:                               ## @.str.5
	.asciz	"-"

L_.str.6:                               ## @.str.6
	.asciz	"*"

L_.str.7:                               ## @.str.7
	.asciz	"^"

L_.str.8:                               ## @.str.8
	.asciz	"range"

L_.str.9:                               ## @.str.9
	.asciz	"OR"

L_.str.10:                              ## @.str.10
	.asciz	"AND"

L_.str.11:                              ## @.str.11
	.asciz	"="

L_.str.12:                              ## @.str.12
	.asciz	"!="

L_.str.13:                              ## @.str.13
	.asciz	"~"

L_.str.14:                              ## @.str.14
	.asciz	"!~"

L_.str.15:                              ## @.str.15
	.asciz	"UNIFY"

L_.str.16:                              ## @.str.16
	.asciz	"<"

L_.str.17:                              ## @.str.17
	.asciz	">"

L_.str.18:                              ## @.str.18
	.asciz	"<="

L_.str.19:                              ## @.str.19
	.asciz	">="

L_.str.20:                              ## @.str.20
	.asciz	","

L_.str.21:                              ## @.str.21
	.asciz	"/"

L_.str.22:                              ## @.str.22
	.asciz	"INTEGER"

	.comm	_yytext,8,3                     ## @yytext
L_.str.23:                              ## @.str.23
	.asciz	"REAL"

L_.str.24:                              ## @.str.24
	.asciz	"["

L_.str.25:                              ## @.str.25
	.asciz	"UPPER_ID"

L_.str.26:                              ## @.str.26
	.asciz	"LOWER_ID"

	.section	__TEXT,__const
	.p2align	4, 0x0                          ## @yyr1
_yyr1:
	.ascii	"\000!\"##$$%%&''((()))***+,,--....//0011222233445566677788889:;;<<=>?"

	.p2align	4, 0x0                          ## @yypgoto
_yypgoto:
	.ascii	"\314\314\314s\314\314\314C\021\022\314\362VT\314\314K\314\314\315H\363EG\004\314\314\314\314\340\314"

	.p2align	4, 0x0                          ## @yydefgoto
_yydefgoto:
	.ascii	"\377\003\004\005\006\00789:;<\017\020\021\022\023\b\024W\025$\026\027\030=\031>\032\033\n\034"

	.section	__TEXT,__cstring,cstring_literals
L_.str.27:                              ## @.str.27
	.asciz	"syntax error"

L_.str.30:                              ## @.str.30
	.asciz	"memory exhausted"

	.globl	_yyin                           ## @yyin
.zerofill __DATA,__common,_yyin,8,3
	.globl	_yyout                          ## @yyout
.zerofill __DATA,__common,_yyout,8,3
	.section	__DATA,__data
	.globl	_yylineno                       ## @yylineno
	.p2align	2, 0x0
_yylineno:
	.long	1                               ## 0x1

	.globl	_yy_flex_debug                  ## @yy_flex_debug
.zerofill __DATA,__common,_yy_flex_debug,4,2
	.globl	_linecounter                    ## @linecounter
	.p2align	2, 0x0
_linecounter:
	.long	1                               ## 0x1

.zerofill __DATA,__bss,_yy_init,1,2     ## @yy_init
.zerofill __DATA,__bss,_yy_start,1,2    ## @yy_start
.zerofill __DATA,__bss,_yy_buffer_stack,8,3 ## @yy_buffer_stack
.zerofill __DATA,__bss,_yy_buffer_stack_top,8,3 ## @yy_buffer_stack_top
.zerofill __DATA,__bss,_yy_c_buf_p,8,3  ## @yy_c_buf_p
.zerofill __DATA,__bss,_yy_hold_char,1,0 ## @yy_hold_char
	.section	__TEXT,__const
	.p2align	4, 0x0                          ## @yy_ec
_yy_ec:
	.ascii	"\000\001\001\001\001\001\001\001\001\002\003\001\001\004\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\005\006\001\001\001\001\001\001\007\b\t\n\013\f\r\016\017\017\017\017\017\017\017\017\017\017\020\021\022\023\024\025\001\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\026\027\001\030\031\032\001\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\033\034\035\036\037\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001\001"

	.p2align	4, 0x0                          ## @yy_accept
_yy_accept:
	.short	0                               ## 0x0
	.short	0                               ## 0x0
	.short	0                               ## 0x0
	.short	37                              ## 0x25
	.short	35                              ## 0x23
	.short	33                              ## 0x21
	.short	30                              ## 0x1e
	.short	32                              ## 0x20
	.short	35                              ## 0x23
	.short	23                              ## 0x17
	.short	24                              ## 0x18
	.short	18                              ## 0x12
	.short	16                              ## 0x10
	.short	8                               ## 0x8
	.short	17                              ## 0x11
	.short	9                               ## 0x9
	.short	20                              ## 0x14
	.short	3                               ## 0x3
	.short	35                              ## 0x23
	.short	7                               ## 0x7
	.short	12                              ## 0xc
	.short	10                              ## 0xa
	.short	13                              ## 0xd
	.short	35                              ## 0x23
	.short	1                               ## 0x1
	.short	27                              ## 0x1b
	.short	28                              ## 0x1c
	.short	19                              ## 0x13
	.short	1                               ## 0x1
	.short	2                               ## 0x2
	.short	25                              ## 0x19
	.short	29                              ## 0x1d
	.short	26                              ## 0x1a
	.short	21                              ## 0x15
	.short	31                              ## 0x1f
	.short	11                              ## 0xb
	.short	22                              ## 0x16
	.short	4                               ## 0x4
	.short	34                              ## 0x22
	.short	0                               ## 0x0
	.short	3                               ## 0x3
	.short	5                               ## 0x5
	.short	14                              ## 0xe
	.short	15                              ## 0xf
	.short	6                               ## 0x6
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	2                               ## 0x2
	.short	0                               ## 0x0

.zerofill __DATA,__bss,_yy_last_accepting_state,4,2 ## @yy_last_accepting_state
.zerofill __DATA,__bss,_yy_last_accepting_cpos,8,3 ## @yy_last_accepting_cpos
	.p2align	4, 0x0                          ## @yy_chk
_yy_chk:
	.short	0                               ## 0x0
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	1                               ## 0x1
	.short	8                               ## 0x8
	.short	17                              ## 0x11
	.short	24                              ## 0x18
	.short	17                              ## 0x11
	.short	28                              ## 0x1c
	.short	40                              ## 0x28
	.short	39                              ## 0x27
	.short	40                              ## 0x28
	.short	37                              ## 0x25
	.short	24                              ## 0x18
	.short	29                              ## 0x1d
	.short	28                              ## 0x1c
	.short	8                               ## 0x8
	.short	24                              ## 0x18
	.short	24                              ## 0x18
	.short	28                              ## 0x1c
	.short	28                              ## 0x1c
	.short	29                              ## 0x1d
	.short	45                              ## 0x2d
	.short	23                              ## 0x17
	.short	46                              ## 0x2e
	.short	29                              ## 0x1d
	.short	29                              ## 0x1d
	.short	22                              ## 0x16
	.short	20                              ## 0x14
	.short	45                              ## 0x2d
	.short	47                              ## 0x2f
	.short	46                              ## 0x2e
	.short	18                              ## 0x12
	.short	45                              ## 0x2d
	.short	45                              ## 0x2d
	.short	46                              ## 0x2e
	.short	46                              ## 0x2e
	.short	47                              ## 0x2f
	.short	16                              ## 0x10
	.short	15                              ## 0xf
	.short	7                               ## 0x7
	.short	47                              ## 0x2f
	.short	47                              ## 0x2f
	.short	3                               ## 0x3
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30

	.p2align	4, 0x0                          ## @yy_base
_yy_base:
	.short	0                               ## 0x0
	.short	0                               ## 0x0
	.short	0                               ## 0x0
	.short	71                              ## 0x47
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	65                              ## 0x41
	.short	13                              ## 0xd
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	52                              ## 0x34
	.short	57                              ## 0x39
	.short	20                              ## 0x14
	.short	41                              ## 0x29
	.short	72                              ## 0x48
	.short	37                              ## 0x25
	.short	72                              ## 0x48
	.short	36                              ## 0x24
	.short	32                              ## 0x20
	.short	19                              ## 0x13
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	21                              ## 0x15
	.short	27                              ## 0x1b
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	25                              ## 0x19
	.short	72                              ## 0x48
	.short	23                              ## 0x17
	.short	24                              ## 0x18
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	72                              ## 0x48
	.short	35                              ## 0x23
	.short	37                              ## 0x25
	.short	43                              ## 0x2b
	.short	72                              ## 0x48

	.p2align	4, 0x0                          ## @yy_def
_yy_def:
	.short	0                               ## 0x0
	.short	48                              ## 0x30
	.short	1                               ## 0x1
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	0                               ## 0x0

	.p2align	4, 0x0                          ## @yy_nxt
_yy_nxt:
	.short	0                               ## 0x0
	.short	4                               ## 0x4
	.short	5                               ## 0x5
	.short	6                               ## 0x6
	.short	7                               ## 0x7
	.short	5                               ## 0x5
	.short	8                               ## 0x8
	.short	9                               ## 0x9
	.short	10                              ## 0xa
	.short	11                              ## 0xb
	.short	12                              ## 0xc
	.short	13                              ## 0xd
	.short	14                              ## 0xe
	.short	15                              ## 0xf
	.short	16                              ## 0x10
	.short	17                              ## 0x11
	.short	18                              ## 0x12
	.short	19                              ## 0x13
	.short	20                              ## 0x14
	.short	21                              ## 0x15
	.short	22                              ## 0x16
	.short	23                              ## 0x17
	.short	24                              ## 0x18
	.short	25                              ## 0x19
	.short	26                              ## 0x1a
	.short	27                              ## 0x1b
	.short	28                              ## 0x1c
	.short	29                              ## 0x1d
	.short	30                              ## 0x1e
	.short	31                              ## 0x1f
	.short	32                              ## 0x20
	.short	33                              ## 0x21
	.short	35                              ## 0x23
	.short	39                              ## 0x27
	.short	45                              ## 0x2d
	.short	40                              ## 0x28
	.short	46                              ## 0x2e
	.short	39                              ## 0x27
	.short	37                              ## 0x25
	.short	40                              ## 0x28
	.short	37                              ## 0x25
	.short	45                              ## 0x2d
	.short	47                              ## 0x2f
	.short	46                              ## 0x2e
	.short	36                              ## 0x24
	.short	45                              ## 0x2d
	.short	45                              ## 0x2d
	.short	46                              ## 0x2e
	.short	46                              ## 0x2e
	.short	47                              ## 0x2f
	.short	45                              ## 0x2d
	.short	44                              ## 0x2c
	.short	46                              ## 0x2e
	.short	47                              ## 0x2f
	.short	47                              ## 0x2f
	.short	43                              ## 0x2b
	.short	42                              ## 0x2a
	.short	45                              ## 0x2d
	.short	47                              ## 0x2f
	.short	46                              ## 0x2e
	.short	41                              ## 0x29
	.short	45                              ## 0x2d
	.short	45                              ## 0x2d
	.short	46                              ## 0x2e
	.short	46                              ## 0x2e
	.short	47                              ## 0x2f
	.short	38                              ## 0x26
	.short	37                              ## 0x25
	.short	34                              ## 0x22
	.short	47                              ## 0x2f
	.short	47                              ## 0x2f
	.short	48                              ## 0x30
	.short	3                               ## 0x3
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30
	.short	48                              ## 0x30

	.comm	_yyleng,8,3                     ## @yyleng
.zerofill __DATA,__bss,_yy_n_chars,8,3  ## @yy_n_chars
	.section	__TEXT,__cstring,cstring_literals
L_.str.33:                              ## @.str.33
	.asciz	"fatal flex scanner internal error--no action found"

L_.str.34:                              ## @.str.34
	.asciz	"out of dynamic memory in yy_create_buffer()"

L_.str.35:                              ## @.str.35
	.asciz	"out of dynamic memory in yy_scan_buffer()"

L_.str.36:                              ## @.str.36
	.asciz	"out of dynamic memory in yy_scan_bytes()"

L_.str.37:                              ## @.str.37
	.asciz	"bad buffer in yy_scan_bytes()"

L_.str.39:                              ## @.str.39
	.asciz	"\n%s at %d: nearby \"%s\"\n\n"

L_.str.41:                              ## @.str.41
	.asciz	"fatal flex scanner internal error--end of buffer missed"

L_.str.42:                              ## @.str.42
	.asciz	"fatal error - scanner input buffer overflow"

L_.str.43:                              ## @.str.43
	.asciz	"input in flex scanner failed"

L_.str.44:                              ## @.str.44
	.asciz	"out of dynamic memory in yy_get_next_buffer()"

L_.str.45:                              ## @.str.45
	.asciz	"out of dynamic memory in yyensure_buffer_stack()"

.zerofill __DATA,__bss,_yy_buffer_stack_max,8,3 ## @yy_buffer_stack_max
L_.str.46:                              ## @.str.46
	.asciz	"%s\n"

.subsections_via_symbols
