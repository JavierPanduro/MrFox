package com.aja.mrfox_javierpandurovillegastest;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aja.mrfox_javierpandurovillegas.MyLogin;
import com.aja.mrfox_javierpandurovillegas.R;

import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<MyLogin> {
private TextView etiqueta;
private Button login;
private EditText etext1;
private EditText etext2;
private MyLogin actividad;

public ExampleInstrumentedTest() {
//		super("com.example.calc", MainActivity.class);
        super(MyLogin.class);
        }

protected void setUp() throws Exception {
        super.setUp();
        actividad = getActivity();
        etiqueta = (TextView) actividad.findViewById(R.id.tvTituloS);
        etext1 = (EditText) actividad.findViewById(R.id.editText);
        etext2 = (EditText) actividad.findViewById(R.id.editText2);
        login = (Button) actividad.findViewById(R.id.login);

        }

protected void tearDown() throws Exception {
        super.tearDown();
        }

public void testAddValues() {
        //on value 1 entry
        TouchUtils.tapView(this, etext1);
        // now on value2 entry
        TouchUtils.tapView(this, etext2);
        // now on Add button
        TouchUtils.clickView(this, login);

        assertTrue("Add result should be...", login.callOnClick());
        }
}
