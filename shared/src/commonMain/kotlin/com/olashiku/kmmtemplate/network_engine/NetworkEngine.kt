package com.olashiku.kmmtemplate.network_engine

import io.ktor.client.*


expect fun  httpClient(config: HttpClientConfig<*>.()-> Unit={}):HttpClient
