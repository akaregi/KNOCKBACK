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

import com.google.common.collect.Lists

object K16 {
    fun divideFile(): Boolean {
        Lists.partition(
            KBUtil.getFileByList("hightemp.txt"),
            KBUtil.readInteger()
        ).mapIndexed { index, list ->
            KBUtil.writeFile("Knockback16/div_$index.log", list)
        }

        return true
    }
}

fun main() = println(K16.divideFile())

