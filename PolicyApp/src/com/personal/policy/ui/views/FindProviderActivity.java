package com.personal.policy.ui.views;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.personal.policy.Provider;
import com.personal.policy.R;
import com.personal.policy.net.NetUtils;
import com.personal.policy.ui.ProviderListAdapter;

public class FindProviderActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.find_provider);
		
		
		ListView list = (ListView) findViewById(R.id.provider_list);
		
		List<Provider> providers = new NetUtils().getProviders("", "");
		
		ProviderListAdapter adapter = new ProviderListAdapter(this, R.layout.provider_list_item, providers );
		list.setAdapter(adapter);
		
	}

}
