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

object K9 {
    private const val sentence = "I couldn't believe that I could actually understand what I was reading : the phenomenal power of the human mind ."

    fun getTypoglycemia() = sentence.split(" ").joinToString(" ") { randomize(it) }

    private fun randomize(s: String): String {
        return when (s.length > 4) {
            true -> transpose(s)
            false -> s
        }
    }

    private fun transpose(s: String): String {
        val head = s.take(1)
        val tail = s.takeLast(1)

        val transposed = s.slice(IntRange(1, s.length - 2)).toList().shuffled().joinToString("")

        return head + transposed + tail
    }
}

fun main() = println(K9.getTypoglycemia())
