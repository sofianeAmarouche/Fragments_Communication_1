package com.example.sofiane.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_One extends Fragment {

    EditText etxtName, etxtDesc;
    Button btnSubmit;
    String name, desc;

    private OnFragmentInteractionListener mListener;

    public Fragment_One() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etxtName = (EditText) view.findViewById(R.id.etxtName);
        etxtDesc = (EditText) view.findViewById(R.id.etxtDesc);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etxtName.getText().toString().trim();
                desc = etxtDesc.getText().toString().trim();

                if(name == null || desc == null) {
                    Toast.makeText(getActivity(), "Both fields required", Toast.LENGTH_SHORT).show();
                } else {
                    mListener.onFragmentInteraction(name, desc);
                    etxtName.setText("");
                    etxtDesc.setText("");
                }
            }
        });
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String name, String desc);
    }

}
