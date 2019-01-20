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
        
        TextView sigla_host = (TextView)vi.findViewById(R.id.sigla_host);
        TextView placar_host = (TextView)vi.findViewById(R.id.placar_host); 
        NetworkImageView pic_host = (NetworkImageView)vi.findViewById(R.id.picurl_host);
        TextView placar_guest = (TextView)vi.findViewById(R.id.placar_guest);
        NetworkImageView pic_guest = (NetworkImageView)vi.findViewById(R.id.picurl_guest);        
        TextView sigla_guest = (TextView)vi.findViewById(R.id.sigla_guest);        
        TextView estadio = (TextView)vi.findViewById(R.id.servico);
        TextView status = (TextView)vi.findViewById(R.id.status);
        
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();


	    switch(viewType){
	    

	       case 1:

	    	   return vi_header;

	       case 2:        

				JogoItem jogo_item = jogoItems.get(position - 1);
		        

				placar_host.setText(jogo_item.getPlacar_host());
		        sigla_host.setText(jogo_item.getSigla_host());     
				placar_guest.setText(jogo_item.getPlacar_guest());
		        sigla_guest.setText(jogo_item.getSigla_guest());		        
		        pic_host.setImageUrl(jogo_item.getPicurl_host(), imageLoader);
		        pic_guest.setImageUrl(jogo_item.getPicurl_guest(), imageLoader);		        
		        //estadio.setText(jogo_item.getEstadio());
		        estadio.setText(Html.fromHtml("<b>" + jogo_item.getDia() + "</b>" + 
		        		" " + jogo_item.getEstadio() + " <b>" + jogo_item.getHora() + "</b>"));
		        status.setText(jogo_item.getStatus());
		        
		        return vi;
	        
	       default:
	            break;
	        	   
	    }  
	    
	    return null;    
		
	}
}
