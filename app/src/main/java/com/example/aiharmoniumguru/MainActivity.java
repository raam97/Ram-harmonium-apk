package com.example.aiharmoniumguru;
import android.app.*;import android.os.*;import android.graphics.Color;import android.view.*;import android.widget.*;import java.util.*;

public class MainActivity extends Activity{
 LinearLayout root; TextView info; int progress=0;
 String[] swar={"Sa","Re","Ga","Ma","Pa","Dha","Ni","Sa"};
 String[][] bhajans={{"Shri Ram Jai Ram","Sa Re Ga | Ga Re Sa | Re Ga Ma | Pa Ma Ga | Re Sa"},{"Hare Krishna","Sa Sa Re Ga | Ga Re Sa | Sa Re Ga Ma | Pa Ma Ga Re"},{"Om Namah Shivaya","Sa Re Ga | Ma Pa Ma Ga | Re Ga Re Sa"}};
 public void onCreate(Bundle b){super.onCreate(b);home();}
 TextView t(String s,int z){TextView x=new TextView(this);x.setText(s);x.setTextSize(z);x.setPadding(16,14,16,14);x.setTextColor(Color.DKGRAY);return x;}
 Button b(String s){Button x=new Button(this);x.setText(s);return x;}
 void base(String s){root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setPadding(12,12,12,12);root.setBackgroundColor(Color.rgb(250,246,239));root.addView(t(s,25));setContentView(root);}
 void home(){base("🎹 AI Harmonium Guru");root.addView(t("Learn harmonium from beginner to pro • Practice bhajans • Track your progress",17));
  Button a=b("🎹 Harmonium Academy");a.setOnClickListener(v->academy());root.addView(a);
  Button c=b("🙏 Bhajan Academy");c.setOnClickListener(v->bhajans());root.addView(c);
  Button p=b("🎹 Practice Harmonium");p.setOnClickListener(v->practice());root.addView(p);
  Button ai=b("🤖 AI Teacher / Exercise");ai.setOnClickListener(v->aiTeacher());root.addView(ai);
  Button pr=b("📊 My Progress");pr.setOnClickListener(v->new AlertDialog.Builder(this).setTitle("My Progress").setMessage("Lessons completed: "+progress+"\nKeep practicing every day!").setPositiveButton("OK",null).show());root.addView(pr);
 }
 void academy(){base("🎹 Harmonium Academy");String[] levels={"Level 1 • Keyboard & Sa Re Ga Ma","Level 2 • Alankar & Saptak","Level 3 • Scales, Taal & Chords","Level 4 • Bhajan Accompaniment","Level 5 • Playing by Ear","Level 6 • Advanced & Pro"};for(String s:levels){Button x=b(s);x.setOnClickListener(v->lesson(((Button)v).getText().toString()));root.addView(x);}back();}
 void lesson(String name){base(name);root.addView(t("Practice slowly. Press the highlighted swar, then repeat without looking.",17));keys();Button done=b("✓ Complete Lesson");done.setOnClickListener(v->{progress++;Toast.makeText(this,"Lesson completed!",Toast.LENGTH_SHORT).show();});root.addView(done);back();}
 void keys(){LinearLayout row=new LinearLayout(this);row.setOrientation(LinearLayout.HORIZONTAL);for(String s:swar){Button k=b(s);k.setTextSize(14);k.setOnClickListener(v->Toast.makeText(this,"♪ "+((Button)v).getText(),Toast.LENGTH_SHORT).show());row.addView(k,new LinearLayout.LayoutParams(0,150,1));}root.addView(row);}
 void bhajans(){base("🙏 Bhajan Academy");root.addView(t("Choose a bhajan. Learn notation, then practice on the harmonium.",16));for(String[] q:bhajans){Button x=b("♪ "+q[0]);x.setOnClickListener(v->bhajan(q));root.addView(x);}back();}
 void bhajan(String[] q){base("♪ "+q[0]);root.addView(t("Sa Re Ga notation",18));root.addView(t(q[1],22));root.addView(t("\nStep 1: play slowly\nStep 2: repeat with rhythm\nStep 3: sing while playing",17));keys();Button rec=b("🎙 Practice / Record");rec.setOnClickListener(v->Toast.makeText(this,"Practice mode started",Toast.LENGTH_SHORT).show());root.addView(rec);back();}
 void practice(){base("🎹 Practice Harmonium");root.addView(t("Tap the keys and build your speed. Use the lesson notation as your guide.",17));keys();back();}
 void aiTeacher(){base("🤖 AI Teacher");root.addView(t("Today's personalized exercise",20));root.addView(t("Sa Re Ga Ma | Re Ga Ma Pa | Ga Ma Pa Dha | Pa Dha Ni Sa\n\nStart at 60 BPM. Repeat 5 times. Then increase by 10 BPM.",18));keys();Button n=b("Generate Next Exercise");n.setOnClickListener(v->{Toast.makeText(this,"Next exercise generated!",Toast.LENGTH_SHORT).show();});root.addView(n);back();}
 void back(){Button x=b("← Home");x.setOnClickListener(v->home());root.addView(x);}
}