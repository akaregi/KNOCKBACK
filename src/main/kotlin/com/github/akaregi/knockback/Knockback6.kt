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

object K6 {
    private val x = nGram("paraparaparadise", 2)
    private val y = nGram("paragraph", 2)

    fun getUnion() = x union y
    fun getIntersect() = x intersect y
    fun getSubtract() = x subtract y

    fun isXContains() = x.contains("se")
    fun isYContains() = y.contains("se")

    private fun nGram(words: String, N: Int): List<String> {
        var remainder = words
        val list = mutableListOf<String>()

        while (remainder.count() >= N) {
            list.add(remainder.take(N))
            remainder = remainder.drop(1)
        }

        return list
    }
}

fun main() {
    println(K6.getUnion())
    println(K6.getIntersect())
    println(K6.getSubtract())

    println(K6.isXContains())
    println(K6.isYContains())
}