/*
 * This is a part of Knockback
 * Copyright (C) 2019 akaregi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.akaregi.knockback

object K12 {
    fun writeEachColumn(): Boolean {
        val file = KBUtil.getFileByList("hightemp.txt").map { it.split(Regex("""\t""")) }

        val col1 = mutableListOf<String>()
        val col2 = mutableListOf<String>()

        file.map {
            col1.add(it[0])
            col2.add(it[1])
        }

        KBUtil.writeFile("col1.log", col1)
        KBUtil.writeFile("col2.log", col2)

        return true
    }
}

fun main() = println(K12.writeEachColumn())
