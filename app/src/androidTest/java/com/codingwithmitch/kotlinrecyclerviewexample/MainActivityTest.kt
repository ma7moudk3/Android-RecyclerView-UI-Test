package com.codingwithmitch.kotlinrecyclerviewexample

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import java.util.regex.Pattern.matches

class MainActivityTest : TestCase() {

    @Rule
    @JvmField
    public var activityRule = ActivityTestRule(MainActivity::class.java)

    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun recyclerViewTest() {
        Espresso.onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    click()
                )
            )

        var recyclerView: RecyclerView = activityRule.activity.findViewById(R.id.recycler_view)
        var itemCount = recyclerView.adapter?.itemCount

        if (itemCount != null) {
            Espresso.onView(withId(R.id.recycler_view)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    itemCount.minus(1)
                )
            )
        }

        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3,click()))

        val nameItem:String = "Mahmoud"
//        Espresso.onView(withText(nameItem)).check(matches(isDisplayed().toString()))


    }

    public override fun tearDown() {}
}
