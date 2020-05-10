package com.example.a0507task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a0507task.fragents.GengduoFragment;
import com.example.a0507task.fragents.HomeFragment;
import com.example.a0507task.fragents.MineFragment;
import com.example.a0507task.fragents.SetFragment;
import com.example.a0507task.fragents.childfragments.JunshiFragment;
import com.example.a0507task.fragents.childfragments.LishiFragment;
import com.example.a0507task.fragents.childfragments.TuijianFragment;
import com.example.a0507task.fragents.childfragments.YuleFragment;
import com.example.a0507task.utils.Message;
import com.example.a0507task.utils.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private ViewPager mViewPager;
    FragmentManager fragmentManager;
    private RadioGroup rgMenu;
    private RadioButton rbHome, rbSet, rbgengduo,rbmine;

    private FragmentTransaction fragmentTransaction;

//recyclerView的加载

    List<Message> messageList;

    //用于存放fragment的集合

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    private void initView() {

        mViewPager = findViewById(R.id.viewpager);
        rgMenu = findViewById(R.id.rg_menu);
        rbHome = findViewById(R.id.rb_home);
        rbSet = findViewById(R.id.rb_set);
        rbgengduo = findViewById(R.id.rb_gengduo);
        rbmine = findViewById(R.id.rb_mine);
        manager = getSupportFragmentManager();
//显示Fragment
        ShowFragment(firstFragment);
        rgMenu.setOnCheckedChangeListener(this);

    }
    private List<Fragment> fragmentList;// 存储所有的Fragment
    private int firstFragment = 0; //第一次加载的Fragment
    private void ShowFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new GengduoFragment());
        fragmentList.add(new SetFragment());
        fragmentList.add(new MineFragment());
        transaction.replace(R.id.frag,fragmentList.get(position));
        transaction.commit();
    }
//    private void addFragmentList() {
//        fragmentList = new ArrayList<>();
//        fragmentList.add(new HomeFragment());
//        fragmentList.add(new GengduoFragment());
//        fragmentList.add(new SetFragment());
//        fragmentList.add(new MineFragment());
//    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//        fragmentTransaction = manager.beginTransaction();
            switch (i) {
            case R.id.rb_home:
//               fragmentTransaction.replace(R.id.frag,new HomeFragment());

                ShowFragment(0);
                rbHome.setChecked(true);
                break;
            case R.id.rb_gengduo:
                ShowFragment(1);
                rbgengduo.setChecked(true);
//                fragmentTransaction.replace(R.id.frag,new GengduoFragment());
                break;
            case R.id.rb_set:
                ShowFragment(2);
                rbSet.setChecked(true);
//                fragmentTransaction.replace(R.id.frag,new SetFragment());
                break;
            case R.id.rb_mine:
                ShowFragment(3);
                rbmine.setChecked(true);
//                fragmentTransaction.replace(R.id.frag,new MineFragment());
                break;
        }
//        fragmentTransaction.commit();
    }





}
