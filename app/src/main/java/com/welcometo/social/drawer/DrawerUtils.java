package com.welcometo.social.drawer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;


import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.welcometo.social.R;
import com.welcometo.social.fragments.FriendsFragment;
import com.welcometo.social.fragments.HelpFragment;
import com.welcometo.social.fragments.LibraryFragment;
import com.welcometo.social.fragments.ProfileFragment;
import com.welcometo.social.fragments.SettingsFragment;

public class DrawerUtils
{
    public static Drawer.Result createDrawer(final AppCompatActivity activity, Toolbar toolbar)
    {
        return new Drawer()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_profile).withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_friends).withIcon(FontAwesome.Icon.faw_user).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_library).withIcon(FontAwesome.Icon.faw_book).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_tint).withIdentifier(4),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question).withIdentifier(5)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener()
                {
                    @Override
                    public void onDrawerOpened(View drawerView)
                    {
                        hideKeyboard(activity);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView)
                    {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem)
                    {
                        if (drawerItem != null)
                        {
                            switch (drawerItem.getIdentifier())
                            {
                                case 1:
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new ProfileFragment()).commit();
                                    break;
                                case 2:
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FriendsFragment()).commit();
                                    break;
                                case 3:
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new LibraryFragment()).commit();
                                    break;
                                case 4:
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new SettingsFragment()).commit();
                                    break;
                                case 5:
                                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HelpFragment()).commit();
                                    break;
                            }
                        }
                    }
                })
                .build();
    }

    private static void hideKeyboard(Activity activity)
    {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            //
        }
    }
}
