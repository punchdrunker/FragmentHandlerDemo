
package com.example.nein37.fragmenthandlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class FromFragment extends BaseHandlerFragment {

    public static final int WHAT_REPLACE_FRAGMENT = 37;

    public FromFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_from, container, false);

        Button button = (Button) rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("LIFECYCLE", "button1 starts commiting fragment");

                        Bundle bundle = new Bundle();
                        bundle.putString(ToFragment.BUNDLE_TOAST_TEXT,"hogehogehogehoge");
                        sendMessage(WHAT_REPLACE_FRAGMENT, bundle);
                    }
                }, 2000);
            }
        });

        Button button2 = (Button) rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // button2を押した直後にアプリがバックグラウンドに回ると IllegalStateException
                        Log.d("LIFECYCLE", "button2 starts commiting fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString(ToFragment.BUNDLE_TOAST_TEXT,"hogehogehogehoge");
                        ToFragment toFragment = new ToFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(getId(), toFragment);
                        ft.addToBackStack("hoge");
                        ft.commit();
                    }
                }, 2000);
            }
        });
        return rootView;
    }

    @Override
    public void processMessage(Message message) {
        switch (message.what) {
            case WHAT_REPLACE_FRAGMENT:
                // bundleも取り出す
                ToFragment fragment = new ToFragment();
                fragment.setArguments(message.getData());
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(getId(), fragment);
                ft.addToBackStack("hoge");
                ft.commit();
                break;
            default:
                break;
        }
    }
}
