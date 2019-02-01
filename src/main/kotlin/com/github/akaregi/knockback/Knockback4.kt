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

object K4 {
    fun getAlchemicalList(): List<Pair<Int, String>> {
        val wordsList = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can.".split(" ")

        val numList = (1..wordsList.count()).toList()

        val alchemical = wordsList.mapIndexed { index, s -> head(index + 1, s) }

        return numList zip alchemical
    }

    private fun head(index: Int, word: String): String {
        val onlyHead = listOf(1, 5, 6, 7, 8, 9, 15, 16, 19)

        return when (onlyHead.contains(index)) {
            true -> word.slice(IntRange(0, 0))
            false -> word.slice(IntRange(0, 1))
        }
    }
}

fun main() = println(K4.getAlchemicalList())