package ru.sbertech.android.codegen.myapplication;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import ru.sbertech.android.codegen.Country;
import ru.sbertech.android.codegen.CountryFactory;
import ru.sbertech.android.codegen.myapplication.factories.FactoryHandmade;
import ru.sbertech.android.codegen.myapplication.factories.FactoryProxy;
import ru.sbertech.android.codegen.myapplication.factories.FactoryReflection;
import ru.sbertech.android.codegen.myapplication.сountry.Germany;
import ru.sbertech.android.codegen.myapplication.сountry.Russia;
import ru.sbertech.android.codegen.myapplication.сountry.USA;


public class MainActivity extends AppCompatActivity {

    private CountryFactory mHandmadeFactory = new FactoryHandmade();
    private CountryFactory mGeneratedFactory = new FactoryProxy();
    private CountryFactory mReflectionFactory = new FactoryReflection(USA.class, Russia.class, Germany.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText countryEditText = findViewById(R.id.country_edit_text);
        TextView resultText = findViewById(R.id.capital_text_view);

        findViewById(R.id.handmade_button).setOnClickListener(
                v -> onButtonClick(countryEditText, resultText, mHandmadeFactory, R.color.red));

        findViewById(R.id.generated_button).setOnClickListener(
                v -> onButtonClick(countryEditText, resultText, mGeneratedFactory, R.color.green));

        findViewById(R.id.reflection_button).setOnClickListener(
                v -> onButtonClick(countryEditText, resultText, mReflectionFactory, R.color.blue));
    }

    private void onButtonClick(EditText from, TextView to, CountryFactory factory, @ColorRes int color) {
        Country country = factory.getCountry(from.getText().toString());
        if (country != null) {
            to.setTextColor(getResources().getColor(color));
            to.setText(country.getCapital());
        } else {
            to.setTextColor(getResources().getColor(color));
            to.setText("Not found");
        }
    }
}
