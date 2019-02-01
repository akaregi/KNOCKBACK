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

import com.google.common.collect.HashMultiset

object K19 {
    fun freqSortedPrefs(): List<Pair<String, Int>> {
        val prefectures = HashMultiset.create(
            KBUtil.getFileByList("hightemp.txt")
                .map { it.split("\t")[0] }
        )

        val prefDistinct = prefectures.distinct()

        return (prefDistinct zip prefDistinct.map { prefectures.count(it) }).sortedBy { it.second }
    }
}

fun main() = println(K19.freqSortedPrefs())
