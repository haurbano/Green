package salt.movil.green.attr;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.security.PublicKey;

/**
 * Created by usuario on 27/02/2016.
 */
public class Atributos {

    @BindingAdapter("app:imgUrl")
    public static void loadImg(ImageView img, String url){
        Uri uri = Uri.parse(url);
        Picasso.with(img.getContext()).load(uri).into(img);
    }

}
