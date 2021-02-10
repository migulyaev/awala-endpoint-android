package tech.relaycorp.relaydroid.background

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.relaycorp.relaydroid.GatewayClient
import kotlin.coroutines.CoroutineContext

class NotificationBroadcastReceiver : BroadcastReceiver() {

    internal var coroutineContext: CoroutineContext = Dispatchers.IO

    override fun onReceive(context: Context?, intent: Intent?) {
        CoroutineScope(coroutineContext).launch {
            GatewayClient.checkForNewMessages()
        }
    }
}