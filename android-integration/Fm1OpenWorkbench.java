import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

/**
 * Java bridge for the FM1 Open "Setup & Tools" action in the existing Android app.
 * Add your Android app's package declaration when copying this into its source tree.
 *
 * This opens the real M-VAVE Workbench in an external browser. It does not connect
 * to an FM-1, write user files, bypass backup gates or flash firmware.
 */
public final class Fm1OpenWorkbench {
    public static final String CATALOG_ID = "fm1-open";
    public static final String OFFICIAL_URL = "https://open.m-vave.com/fm1-workbench";

    private Fm1OpenWorkbench() { }

    public static boolean supports(String catalogId) {
        return CATALOG_ID.equals(catalogId);
    }

    /** Returns false if no browser could be launched. */
    public static boolean open(Activity activity) {
        if (activity == null) return false;
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(OFFICIAL_URL));
        browser.addCategory(Intent.CATEGORY_BROWSABLE);
        try {
            activity.startActivity(browser);
            return true;
        } catch (ActivityNotFoundException | SecurityException exception) {
            return false;
        }
    }
}
