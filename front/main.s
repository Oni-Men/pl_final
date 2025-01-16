	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 14, 0	sdk_version 15, 0
	.globl	_main                           ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	_linecounter@GOTPCREL(%rip), %rax
	movl	$1, (%rax)
	callq	_yyparse
	testl	%eax, %eax
	jne	LBB0_2
## %bb.1:
	movq	___stderrp@GOTPCREL(%rip), %rax
	movq	(%rax), %rcx
	leaq	L_.str(%rip), %rdi
	movl	$28, %esi
	movl	$1, %edx
	callq	_fwrite
LBB0_2:
	xorl	%eax, %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_cons                           ## -- Begin function cons
	.p2align	4, 0x90
_cons:                                  ## @cons
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
	.cfi_offset %rbx, -32
	.cfi_offset %r14, -24
	movq	%rsi, %rbx
	movq	%rdi, %r14
	movl	$24, %edi
	callq	_malloc
	movl	$0, (%rax)
	movq	%r14, 8(%rax)
	movq	%rbx, 16(%rax)
	popq	%rbx
	popq	%r14
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_node                           ## -- Begin function node
	.p2align	4, 0x90
_node:                                  ## @node
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
	movq	%rsi, %rbx
	movq	%rdi, %r14
	movl	$24, %edi
	callq	_malloc
	movq	%rax, %r15
	movl	$1, (%rax)
	movq	%r14, %rdi
	callq	_strdup
	movq	%rax, 8(%r15)
	movq	%rbx, 16(%r15)
	movq	%r15, %rax
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_leaf                           ## -- Begin function leaf
	.p2align	4, 0x90
_leaf:                                  ## @leaf
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
	movq	%rsi, %rbx
	movq	%rdi, %r14
	movl	$24, %edi
	callq	_malloc
	movq	%rax, %r15
	movl	$2, (%rax)
	movq	%r14, %rdi
	callq	_strdup
	movq	%rax, 8(%r15)
	movq	%rbx, %rdi
	callq	_strdup
	movq	%rax, 16(%r15)
	movq	%r15, %rax
	addq	$8, %rsp
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_tree                           ## -- Begin function tree
	.p2align	4, 0x90
_tree:                                  ## @tree
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	$1, %esi
	callq	_visit
	movl	$10, %edi
	popq	%rbp
	jmp	_putchar                        ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.globl	_visit                          ## -- Begin function visit
	.p2align	4, 0x90
_visit:                                 ## @visit
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
	movl	%esi, %r14d
	movq	%rdi, %rbx
	movl	$10, %edi
	callq	_putchar
	testl	%r14d, %r14d
	jle	LBB5_3
## %bb.1:                               ## %.lr.ph.preheader
	leaq	L_.str.2(%rip), %r15
	movl	%r14d, %r12d
	.p2align	4, 0x90
LBB5_2:                                 ## %.lr.ph
                                        ## =>This Inner Loop Header: Depth=1
	movq	%r15, %rdi
	xorl	%eax, %eax
	callq	_printf
	decl	%r12d
	jne	LBB5_2
LBB5_3:                                 ## %._crit_edge
	movl	(%rbx), %eax
	testl	%eax, %eax
	je	LBB5_4
## %bb.5:
	cmpl	$1, %eax
	je	LBB5_6
LBB5_7:
	cmpl	$2, %eax
	jne	LBB5_8
LBB5_9:
	leaq	L_.str.7(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	8(%rbx), %rsi
	leaq	L_.str.6(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	16(%rbx), %rsi
	leaq	L_.str.8(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movl	$41, %edi
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	jmp	_putchar                        ## TAILCALL
LBB5_4:
	leaq	L_.str.3(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	8(%rbx), %rdi
	leal	1(%r14), %r15d
	movl	%r15d, %esi
	callq	_visit
	movq	16(%rbx), %rdi
	movl	%r15d, %esi
	callq	_visit
	movl	$41, %edi
	callq	_putchar
	movl	(%rbx), %eax
	cmpl	$1, %eax
	jne	LBB5_7
LBB5_6:
	leaq	L_.str.5(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	8(%rbx), %rsi
	leaq	L_.str.6(%rip), %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	16(%rbx), %rdi
	incl	%r14d
	movl	%r14d, %esi
	callq	_visit
	movl	$41, %edi
	callq	_putchar
	movl	(%rbx), %eax
	cmpl	$2, %eax
	je	LBB5_9
LBB5_8:
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"\nparser successfully ended\n\n"

L_.str.2:                               ## @.str.2
	.asciz	"    "

L_.str.3:                               ## @.str.3
	.asciz	"cons("

L_.str.5:                               ## @.str.5
	.asciz	"node("

L_.str.6:                               ## @.str.6
	.asciz	"%s "

L_.str.7:                               ## @.str.7
	.asciz	"leaf("

L_.str.8:                               ## @.str.8
	.asciz	"%s"

.subsections_via_symbols
