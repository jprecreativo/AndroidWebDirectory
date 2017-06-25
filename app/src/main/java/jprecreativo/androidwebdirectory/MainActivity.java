package jprecreativo.androidwebdirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
{
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);

        // Activamos Javascript:

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Url que carga la app (webview):

        mWebView.loadUrl(" http://www.google.es");

        // Forzamos el webview para que abra los enlaces internos dentro de la la APP:

        mWebView.setWebViewClient(new WebViewClient());

        // Forzamos el webview para que abra los enlaces externos en el navegador

        mWebView.setWebViewClient(new MyAppWebViewClient());
    }

    @Override
    public void onBackPressed()
    {
        if(mWebView.canGoBack())
            mWebView.goBack();

         else
            super.onBackPressed();
    }
}
