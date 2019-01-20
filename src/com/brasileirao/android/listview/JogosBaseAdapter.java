package com.brasileirao.android.listview;

import java.util.List;

import com.brasileirao.android.R;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class JogosBaseAdapter extends BaseAdapter {
	
	private static LayoutInflater inflater = null;
	private List<JogoItem> jogoItems;
	private Context context;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	
	private static final Integer TYPE1   = 1;
	private static final Integer TYPE2   = 2;
	
	
	
	public JogosBaseAdapter(Context context, List<JogoItem> jogoItems){
		this.jogoItems = jogoItems;
		this.context = context;
		
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jogoItems.size() + 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public int getItemViewType(int position) {

		if (position == 0) {
			return TYPE1;
		} else {
			return TYPE2;
		}
	    	
	}	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		
		if (inflater == null)
			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		int viewType = this.getItemViewType(position);

		View vi	 = convertView;
        View vi_header = convertView;
        
        vi 	= inflater.inflate(R.layout.jogos_item, null);
        vi_header = inflater.inflate(R.layout.jogos_header_item, null);
        
        TextView sigla_host = (TextView)vi.findViewById(R.id.sigla_host); // title
        TextView placar_host = (TextView)vi.findViewById(R.id.placar_host); 
        NetworkImageView thumb_image = (NetworkImageView)vi.findViewById(R.id.profilePic);
        
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();


	    switch(viewType){
	    

	       case 1:

	    	   return vi_header;

	       case 2:        

				JogoItem jogo_item = jogoItems.get(position - 1);
		        

				placar_host.setText(jogo_item.getPlacar_host());
		        sigla_host.setText(jogo_item.getSigla_host());     

		        
		        thumb_image.setImageUrl(jogo_item.getPicurl_host(), imageLoader);

		        return vi;
	        
	       default:
	            break;
	        	   
	    }  
	    
	    return null;    
		
	}
}
