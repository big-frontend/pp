package com.jamesfchen.foundation

import android.content.Context
import com.jamesfchen.ibc.Router
import com.jamesfchen.ibc.router.ISchemaRouter
import java.net.URI

/**
 * 解析schema判断跳转的意图是h5 container还是react container
 */
@Router(name = "PiscesRouter")
class PiscesRouter :ISchemaRouter {
    override fun onOpenUri(cxt: Context, uri: URI): Boolean {
        
        return false
    }
}