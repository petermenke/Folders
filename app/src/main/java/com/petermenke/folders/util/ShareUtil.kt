package com.petermenke.folders.util

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.Person
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.petermenke.folders.MainActivity
import com.petermenke.folders.R


private const val TAG = "MyActivity"

object ShareUtil {
    private const val SHARE_CATEGORY = "com.petermenke.folders.category.FOLDERS_TARGET"

    private fun String.toShortcut(context: Context): ShortcutInfoCompat {
        val folderName: String = this;
        return ShortcutInfoCompat.Builder(context, folderName)
            .setShortLabel(folderName)
            .setLongLabel("Long label + $folderName")
            .setPerson(
                Person.Builder()
                    .setName("Mr. $folderName")
                    .setKey(folderName)
                    .build()
            )
            .setIcon(IconCompat.createWithResource(context, R.drawable.folder_icon))
            .setCategories(setOf(SHARE_CATEGORY))
            .setIntent(Intent(context, MainActivity::class.java).apply {
                action = Intent.ACTION_SEND
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    putExtra(Intent.EXTRA_SHORTCUT_ID, folderName)
                }
            })
            .setLongLived(true)
            .setRank(0)
            .build()
    }

    fun publishMemeShareShortcuts(context: Context) {
        ShortcutManagerCompat.addDynamicShortcuts(context, arrayListOf("alpha", "beta", "gamma")
            .take(ShortcutManagerCompat.getMaxShortcutCountPerActivity(context))
            .map {

                it.toShortcut(context)
            }
        )
    }

    fun unPublishMemeShareShortcuts(context: Context) {
        ShortcutManagerCompat.removeAllDynamicShortcuts(context)
    }
}

