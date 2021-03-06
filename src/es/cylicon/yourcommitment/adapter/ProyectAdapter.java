package es.cylicon.yourcommitment.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.Proyect;

public class ProyectAdapter extends ArrayAdapter<Proyect> {

	private final Context context;

	public ProyectAdapter(final Context context, final int resource,
			final List<Proyect> objects) {
		super(context, resource, objects);
		this.context = context;
	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		if (convertView == null) {
			final LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.activity_proyects_fila, null);
		}

		setValuesFromProyectInRow(getItem(position), convertView);

		return convertView;
	}

	private void setValuesFromProyectInRow(final Proyect proyect,
			final View vista) {
		final TextView titulo = (TextView) vista.findViewById(R.id.titulo);
		titulo.setText(proyect.getName());
		final TextView descripcion = (TextView) vista
				.findViewById(R.id.descripcion);
		descripcion.setText(proyect.getDescription());
		final ImageView imagen = (ImageView) vista
				.findViewById(R.id.imagenCategoria);
		Drawable drawable;
		try {
			drawable = Drawable.createFromStream(
					context.getAssets()
							.open("test/" + proyect.getCategory().getImage()
									+ ".png"), null);
			imagen.setImageDrawable(drawable);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
