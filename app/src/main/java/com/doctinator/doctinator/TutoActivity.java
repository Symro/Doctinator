package com.doctinator.doctinator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TutoActivity extends ActionBarActivity {

    int i = 0;
    String[] steps = new String[0];
    String title = "";
    String description = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuto);

        // Set actionbar title
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(getResources().getString(R.string.titleFirstHelp));

        Bundle tutorialId = getIntent().getExtras();
        int id = tutorialId.getInt("key");

        // Log id from last activity
        System.out.println(id);

        // Alert
        if(id == 1){
            showDialog();
        }

        switch (id){
            case 0:
                steps = new String[]{
                    "Si la victime porte des lunettes, ôtez-les lui.",
                    "Assurez-vous que ses jambes sont allongées côte à côte. Si ce n'est pas le cas, rapprochez-les délicatement l'une de l'autre de manière à les placer dans l'axe du corps.",
                    "Disposez le bras de la victime le plus proche de vous à angle droit de son corps. Pliez ensuite son coude tout en gardant la paume de sa main tournée vers le haut.",
                    "Placez-vous à genoux ou en trépied à côté de la victime.",
                    "Saisissez l'autre bras de la victime d'une main, placez le dos de sa main contre son oreille, de votre côté.",
                    "Maintenez la main de la victime pressée contre son oreille, paume contre paume.",
                    "Attrapez la jambe la plus éloignée de vous avec l'autre main, juste derrière le genou, et relevez-la tout en gardant le pied au sol.",
                    "Placez-vous assez loin de la victime, au niveau de son thorax, pour pouvoir la tourner sur le côté vers vous, sans avoir à reculer.",
                    "Faites rouler la victime en tirant sur sa jambe jusqu'à ce que le genou touche le sol.",
                    "Dégagez doucement votre main de sous la tête de la victime en maintenant son coude de votre autre main afin de ne pas entraîner sa main et d'éviter ainsi toute mobilisation de sa tête.",
                    "Ajustez la jambe située au-dessus de sorte que la hanche et le genou soient à angle droit.',",
                    "Ouvrez la bouche de la victime d'une main, avec le pouce et l'index, sans mobiliser la tête, afin de permettre l'écoulement des liquides vers l'extérieur.",
                    "Demandez à quelqu'un d'appeler les secours ou bien allez chercher de l'aide si vous êtes seul.",
                    "Vérifiez régulièrement que la respiration est normale."
                };
                title = "Inconscience";
                description = "Si la victime est inconsciente, et si sa poitrine se soulève régulièrement, il faut libérer les voies aériennes et la placer en position latérale de sécurité. Pour se faire:";
                break;
            case 1:
                steps = new String[]{
                        "Vérifiez que la victime ne réagit pas et ne respire pas normalement",
                        "Demandez à quelqu'un de prévenir les secours d'urgence (le 15 ou le 18) et d'apporter immédiatement un défibrillateur automatisé externe (s'il est disponible). Faites tout cela vous-même si vous êtes seul.",
                        "Commencez par effectuer 30 compressions thoraciques.",
                        "Pratiquez ensuite 2 insufflations.",
                        "Alternez 30 compressions thoraciques et 2 insufflations.",
                        "Continuez la réanimation jusqu'à ce que les secours d'urgence arrivent et poursuivent la réanimation, ou que la victime reprenne une respiration normale."
                };
                title = "Arrêt cardiaque";
                description = "";
                break;
            case 2:
                steps = new String[]{
                    "Vérifier que la victime ne peut ni parler, ni respirer, ni tousser. Elle peut émettre des sifflements ou tenter de tousser sans émettre de bruit.",
                    "Donnez un maximum de 5 claques dans le dos de la victime. Après chaque claque, vérifiez si tout rentre dans l'ordre.",
                    "Si les claques dans le dos n'ont pas d'effet, effectuez un maximum de 5 compressions abdominales.",
                    "Si le problème n'est toujours pas résolu, alternez 5 claques dans le dos et 5 compressions abdominales.",
                    "Si la victime perd connaissance, posez-la délicatement au sol et alertez immédiatement les secours, puis entreprenez une réanimation cardio-pulmonaire en commençant par effectuer 30 compressions thoraciques",
                    "Poursuivez la réanimation jusqu'à ce que les secours arrivent ou que la victime reprenne une respiration normale."
                };
                title = "Étouffement";
                description = "";
                break;
            case 3:
                steps = new String[]{
                    "Dans le cas d’une fracture d’un membre supérieur, immobilisez le, puis contactez le SAMU ou les Pompiers, ou emmenez la victime dans un centre hospitalier qui pourra la prendre en charge. Dans le cas d’un membre inférieur, contactez directement  le SAMU ou les Pompiers."
                };
                title = "Fracture";
                description = "";
                break;
            case 4:
                steps = new String[]{
                    "Evitez, si possible, tout contact avec le sang de la victime ; demandez-lui de comprimer elle-même sa blessure. Sinon, exercez une pression directement sur la plaie avec vos mains protégées (gants jetables, sac plastique ou linge).",
                    "Allongez la victime en position horizontale.",
                    "Demandez à une personne présente d'alerter les secours ou faites-le vous-même si vous êtes seul.",
                    "Si la plaie continue de saigner, comprimez-la encore plus fermement.",
                    "Poursuivez la compression sur la plaie jusqu'à l'arrivée des secours.",
                    "Si vous devez vous libérer (par exemple pour aller donner l'alerte), appliquez un tampon relais pour remplacer votre compression manuelle.",
                    "Lavez-vous les mains après avoir effectué ces premiers secours."
                };
                title = "Plaie";
                description = "";
                break;
            case 5:
                steps = new String[]{
                    "Refroidir immédiatement la brûlure à l’eau froide (non glacée), pendant cinq minutes, pour éviter qu’elle ne s’étende davantage et pour soulager la douleur.",
                    "Retirer les vêtements autour de la zone touchée à l’exception de ceux qui adhèrent à la peau (vêtements synthétiques), ainsi que bagues, bracelets, montres, chaussures du membre brûlé.",
                    "Evaluer la gravité de la brûlure:\n" +
                            "1er degré :  peau rouge, douloureuse, légèrement gonflée.\n" +
                            "2ème degré : formation de cloques sur la peau.\n" +
                            "3ème degré : Peau noire ou grisâtre.\n",
                    "Les brûlures du 1er degré peuvent être soulagées par des crèmes calmantes et cicatrisantes. Pour les autres, lorsque les ampoules sont peu volumineuses, ne pas les percer, elles protègent la brûlure. Si elles sont rompues : désinfecter et recouvrir d’un pansement.\n" +
                            "Si la lésion est profonde, contactez le SAMU ou les Pompiers si ce n’est pas déjà fait.",
                    "Plaie",
                    "Brûlure",
                    "Piqûre / morsure"
                };
                title = "Brûlure";
                description = "";
                break;
        }

        //Get textViews and set text to it
        final TextView tutorialText = (TextView) findViewById(R.id.tutorialText);
        final TextView tutorialTitle = (TextView) findViewById(R.id.tutorialTitle);
        final TextView tutorialDescription = (TextView) findViewById(R.id.tutorialDescription);
        tutorialText.setText(steps[i]);
        tutorialTitle.setText(title);
        tutorialDescription.setText(description);

        // Listeners
        Button nextStep = (Button) findViewById(R.id.nextStep);
        // No button click redirection
        nextStep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i++;
                if (i < steps.length){
                    tutorialText.setText(steps[i]);
                }else{
                    i = 0;
                    tutorialText.setText(steps[i]);
                }
            }
        });

    }

    private void showDialog() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Attention le problème semble sérieux !");
        alert.setMessage("Si cela n'est pas déjà fait appelez immédiatement les secours ! La vie de la personne que vous essayez de sauver en dépend !");

        // redirect to callListActivity
        alert.setPositiveButton("Appeler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent callListScreen = new Intent(getApplicationContext(), CallListActivity.class);
                startActivity(callListScreen);
            }
        });

        // Close modal
        alert.setNegativeButton("Ne rien faire", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tuto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
