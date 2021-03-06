package es.cylicon.yourcommitment;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import es.cylicon.yourcommitment.activity.MenuActivity;

public class MapActivity extends MenuActivity {

	@InjectView(R.id.mapa)
	private WebView webView;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setPluginsEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(final WebView view, final String url) {
				webView.loadUrl("javascript:(function() { "
						+ "document.getElementsByClassName('leyend-wrapper')[0].style.display = 'none'; "
						+ "})()");
			}
		});
		webView.loadUrl("http://yourcommitment.org/");
	}
}
