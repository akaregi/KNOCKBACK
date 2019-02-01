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

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

object UnitedKingdom {
    private val UKText = Countries.getCountry("イギリス").text.split("\n")

    // Knockback 20
    fun getUKText() = KBUtil.getFile("jawiki-country.json")
        .readLines()
        .map { jacksonObjectMapper().readValue<CountryData>(it) }
        .first { it.title == "イギリス" }
        .text

    // Knockback 21
    fun getCategoriesData(): List<String> = UKText
        .filter { Regex("""\[\[Category.*]]""").matches(it) }

    // Knockback 22
    fun getCategoriesName(): List<String> = getCategoriesData()
        .map { Regex("""\[\[Category:([^|\n]*)\|?.*]]""").matchEntire(it)!!.groupValues.last() }

    // Knockback 23
    fun getSections(): List<Pair<Int, String>> {
        val regex = Regex("""^\s*(=+)\s*([^=]+)\s*=+""")

        return UKText
            .filter { regex.matches(it) }
            .map { regex.find(it)?.groupValues ?: run { emptyList<String>() } }
            .map { Pair(it[1].count(), it.last()) }
    }

    // Knockback 24
    fun getFileRefs(): List<String> {
        val regex = Regex("""\[\[(?:File|ファイル):([^|]*).*]]""")

        return UKText
            .filter { regex.matches(it) }
            .map { regex.find(it)?.groupValues ?: run { emptyList<String>() } }
            .map { it.last() }
    }

    // Knockback 25
    fun getInformation(): List<Pair<String, String>> {
        val text = Regex("""\{\{基礎情報 国(\n.*?)*}}\n""")
            .find(Countries.getCountry("イギリス").text)
            ?.value
            ?: run { "" }

        return text
            .split(Regex("""\n\|"""))
            .filter { Regex("""(.*) = (.*\n?)*""").matches(it) }
            .map { it.split(" = ") }
            .map { Pair(it.first(), it.last()) }
    }

    // Knockback 26
    fun getInfoWithoutEmphasize() =
        getInformation().map { Pair(
            it.first,
            it.second
                .replace(Regex("""'{2,5}"""), "")
        )}

    // Knockback 27
    fun getInfoWithoutLinks() =
        getInformation().map { Pair(
            it.first,
            it.second
                .replace(Regex("""\[\[(?:[^|\]]*\|)*([^|\]]*)]]"""), "$1")
                .replace(Regex("""'{2,5}"""), "")
        )}

    // Knockback 28
    fun getInformationRaw() =
        getInformation().map { Pair(
            it.first,
            it.second
                .replace(Regex("""'{2,5}"""), "")
                .replace(Regex("""\[\[(?:[^|\]]*\|)*([^|\]]*)]]"""), "$1")
                .replace(Regex("""\{\{lang\|.*?\|(.*?)}}"""), "$1")
                .replace(Regex("""<.*?>"""), "")
                .replace(Regex("""\n\*+"""), "\n")
        )}
}
