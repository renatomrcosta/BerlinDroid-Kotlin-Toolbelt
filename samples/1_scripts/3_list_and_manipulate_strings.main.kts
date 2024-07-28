#!/usr/bin/env kotlin

@file:DependsOn("eu.jrie.jetbrains:kotlin-shell-core:0.2.1")

import eu.jrie.jetbrains.kotlinshell.shell.shell


println("Starting transformation")
shell {
    val transformationLambda = stringLambda { it.toUpperCase() to "" }
    pipeline { "ls".process() pipe transformationLambda }
}
println("transformation complete")
