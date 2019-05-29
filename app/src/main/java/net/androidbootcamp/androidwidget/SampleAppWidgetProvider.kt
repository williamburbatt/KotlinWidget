package net.androidbootcamp.androidwidget

import android.appwidget.AppWidgetProvider
import android.appwidget.AppWidgetManager
import android.widget.RemoteViews
import android.app.PendingIntent
import android.content.Context
import android.content.Intent



class SampleAppWidgetProvider : AppWidgetProvider(){

    fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {

        // Create an Intent to launch MainActivity when clicked
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.layout_widget_sample)
        views.setOnClickPendingIntent(R.id.widgetImageView, pendingIntent)

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

   override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}