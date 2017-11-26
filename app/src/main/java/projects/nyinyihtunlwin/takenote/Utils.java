package projects.nyinyihtunlwin.takenote;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Dell on 11/23/2017.
 */

public class Utils {
    public static void showToast(Context context, String message) {
        Toast t = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        t.show();
    }
}
