package com.personal.policy.ui.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.personal.policy.Claim;
import com.personal.policy.R;
import com.personal.policy.net.NetUtils;
import com.personal.policy.ui.KeyValueListAdapter;
import com.personal.policy.ui.KeyValueListItem;

public class MyClaimsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.myclaims);
		
		NetUtils net = new NetUtils();
		List<Claim> claims = net.getClaims("dummy");
		
		ListView list = (ListView) findViewById(R.id.dependent_list);
		
		List<KeyValueListItem> dependents = new ArrayList<KeyValueListItem>();
		
		for ( Claim c : claims) {
			dependents.add( new KeyValueListItem(c.getDependantName(), ">>"));
		}
		
		KeyValueListAdapter adapter = new KeyValueListAdapter(this, R.layout.mypolicy_list_item, dependents);
		list.setAdapter( adapter );
	}

}
