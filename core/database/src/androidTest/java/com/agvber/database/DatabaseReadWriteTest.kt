package com.agvber.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.agvber.database.dao.BookmarkDao
import com.agvber.database.di.DatabaseModule.providesAppDatabase
import com.agvber.database.model.BookmarkEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DatabaseReadWriteTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var db: AppDatabase
    private lateinit var bookmarkDao: BookmarkDao

    @Before
    fun createDB() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        db = providesAppDatabase(appContext)
        bookmarkDao = db.bookmarkDao()
    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun resetDB() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        appContext.deleteDatabase("prography-db")
    }

    @Test
    fun bookmarkDatReadWriteTest() = runTest(testDispatcher) {
        val bookmarkEntities = listOf<BookmarkEntity>(
            BookmarkEntity(
                id = "abjd-nw",
                title = "title",
                description = "description",
                userName = "minjun",
                tags = listOf("1", "2", "백두산"),
                url = BookmarkEntity.Url(
                    raw = "https://raw",
                    full = "https://full",
                    regular = "https://regular",
                    small = "https://small",
                    thumb = "https://thumb",
                    smallS3 = "https://smallS3"
                )
            )
        )
        bookmarkDao.insertBookmark(bookmarkEntities)
        val result = bookmarkDao.getBookmarkEntity().first()
        Assert.assertEquals("abjd-nw", result.first().id)
    }

    @Test
    fun deleteBookmarkTest() = runTest(testDispatcher) {
        bookmarkDao.deleteBookmark("abjd-nw")
        val result = bookmarkDao.getBookmarkEntity().first()
        Assert.assertTrue(result.isEmpty())
    }

}