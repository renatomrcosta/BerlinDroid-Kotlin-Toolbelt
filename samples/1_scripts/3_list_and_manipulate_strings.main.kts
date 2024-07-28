#!/usr/bin/env kotlin

@file:DependsOn("eu.jrie.jetbrains:kotlin-shell-core:0.2.1")

import eu.jrie.jetbrains.kotlinshell.shell.shell

shell {
    val transformationLambda = stringLambda {
        it.toUpperCase() to ""
    }
    pipeline { "ls".process() pipe transformationLambda }
}
