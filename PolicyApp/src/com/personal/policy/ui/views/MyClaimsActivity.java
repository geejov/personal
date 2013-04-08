package com.personal.policy.ui.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

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
		
		final NetUtils net = new NetUtils();
		List<Claim> claims = net.getClaims("dummy");
		
		ListView list = (ListView) findViewById(R.id.dependent_list);
		
		List<KeyValueListItem> dependents = new ArrayList<KeyValueListItem>();
		
		for ( Claim c : claims) {
			dependents.add( new KeyValueListItem(c.getDependantName(), ">>"));
		}
		
		KeyValueListAdapter adapter = new KeyValueListAdapter(this, R.layout.mypolicy_list_item, dependents);
		list.setAdapter( adapter );
		
		list.setOnItemClickListener( new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				TextView txtDependent = (TextView) view.findViewById(R.id.txtLabel);
				Intent i = new Intent(MyClaimsActivity.this, ClaimDetailActivity.class);
				i.putExtra("user", "dummy");
				i.putExtra("dependent", txtDependent.getText());
				startActivity(i);
			}
		});
	}

}
