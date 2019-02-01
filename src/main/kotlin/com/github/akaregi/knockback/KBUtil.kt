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

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import kotlin.math.absoluteValue

object KBUtil {
    fun readInteger(): Int {
        print("% ")
        val req: String = readLine() ?: run { return 1 }

        return try {
            req.toInt().absoluteValue
        } catch (e: NumberFormatException) {
            return 1
        }
    }

    fun writeFile(name: String, data: List<String>): Path =
        Files.write(
            Paths.get("src/main/resources/$name"),
            data,
            Charset.forName("UTF-8"),
            StandardOpenOption.CREATE
        )

    fun getFileByList(path: String) = getFile(path).readLines()

    fun getFile(path: String) = Paths.get("src/main/resources/$path").toFile()!!
}
