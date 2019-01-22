package com.brasileirao.android.listview;

import java.util.List;

import com.brasileirao.android.R;





import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class LancesBaseAdapter extends BaseAdapter {
	
	private static LayoutInflater inflater = null;
	private List<LanceItem> lanceItems;
	private Context context;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();
	
	private static final Integer TYPE1   = 1;
	private static final Integer TYPE2   = 2;
	private static final Integer TYPE3   = 3;
	
	
	
	public LancesBaseAdapter(Context context, List<LanceItem> lanceItems){
		this.lanceItems = lanceItems;
		this.context = context;
		
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return lanceItems.size() + 1;
		return lanceItems.size() + 2;
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
		} else if(position == 1) {
			return TYPE2;
		} else {
			return TYPE3;
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
        View vi_jogo = convertView;        
        
        //vi 	= inflater.inflate(R.layout.lances_item, null);
        vi 	= inflater.inflate(R.layout.lances_item, null);
        vi_header = inflater.inflate(R.layout.jogos_header_item, null);
        vi_jogo = inflater.inflate(R.layout.jogos_item, null); 

        TextView l_sigla_host = (TextView)vi_jogo.findViewById(R.id.sigla_host);
        TextView l_placar_host = (TextView)vi_jogo.findViewById(R.id.placar_host); 
        NetworkImageView l_pic_host = (NetworkImageView)vi_jogo.findViewById(R.id.picurl_host);
        TextView l_placar_guest = (TextView)vi_jogo.findViewById(R.id.placar_guest);
        NetworkImageView l_pic_guest = (NetworkImageView)vi_jogo.findViewById(R.id.picurl_guest);        
        TextView l_sigla_guest = (TextView)vi_jogo.findViewById(R.id.sigla_guest);        
        TextView l_estadio = (TextView)vi_jogo.findViewById(R.id.servico);
        TextView l_status = (TextView)vi_jogo.findViewById(R.id.status);
        
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

        
        TextView minutes = (TextView)vi.findViewById(R.id.minutes);
        TextView extra_info = (TextView)vi.findViewById(R.id.extra_info);
        TextView text1 = (TextView)vi.findViewById(R.id.text1);
        TextView text2 = (TextView)vi.findViewById(R.id.text2);
        
	    switch(viewType){
	    

	       case 1:

	    	   return vi_header;

	    	   
	       case 2:
	    	   
	    	   LanceItem jogo_item = lanceItems.get(position - 1);
	    	   
	    	   

				l_placar_host.setText(jogo_item.getPlacar_host());
				l_sigla_host.setText(jogo_item.getSigla_host());     
				l_placar_guest.setText(jogo_item.getPlacar_guest());
				l_sigla_guest.setText(jogo_item.getSigla_guest());		        
				l_pic_host.setImageUrl(jogo_item.getPicurl_host(), imageLoader);
				l_pic_guest.setImageUrl(jogo_item.getPicurl_guest(), imageLoader);		        

				l_estadio.setText(Html.fromHtml("<b>" + jogo_item.getDia() + "</b>" + 
		        		" " + jogo_item.getEstadio() + " <b>" + jogo_item.getHora() + "</b>"));

				l_status.setText("LANCE A LANCE");
				
		        return vi_jogo;
		        
	       case 3:  
	    	    

				LanceItem lance_item = lanceItems.get(position - 2);
				
			    if (lance_item.getMinutes() != null && !lance_item.getMinutes().equals("")) {

		            minutes.setText(lance_item.getMinutes());
		            minutes.setVisibility(View.VISIBLE);
	            
	            } else {
		            minutes.setVisibility(View.GONE);
	            }	
		        //---------
		        extra_info.setText(lance_item.getExtra_info());
		        //---------
			    if (lance_item.getText1() != null && !lance_item.getText1().equals("")) {

			    	text1.setText(lance_item.getText1());
			    	text1.setVisibility(View.VISIBLE);
	            
	            } else {
	            	text1.setVisibility(View.GONE);
	            }	
		        
		        //text1.setText(lance_item.getText1());
		        text2.setText(lance_item.getText2());
				
				
		        return vi;
	        
	       default:
	            break;
	        	   
	    }  
	    
	    return null;    
		
	}
}
