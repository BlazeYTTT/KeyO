package com.example.keyo;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.Objects;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull MainModel model) {
        holder.name.setText(model.getName());
        holder.subname.setText(model.getSubname());
        holder.orientationq.setText(model.getOrientationq());
        holder.reproductionq.setText(model.getReproductionq());
        holder.speakq.setText(model.getSpeakq());

        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.info_popup))
                        .setExpanded(false)
                        .create();

                View view = dialogPlus.getHolderView();

                TextView txtOrient = view.findViewById(R.id.txtOrient);
                TextView txtPam = view.findViewById(R.id.txtPam);
                TextView txtVospr = view.findViewById(R.id.txtVospr);
                TextView Orient = view.findViewById(R.id.orient);
                TextView Pam = view.findViewById(R.id.pam);
                TextView Vospr = view.findViewById(R.id.vospr);
                TextView txtName = view.findViewById(R.id.txtName);

                TextView recom1 = view.findViewById(R.id.recom1);
                TextView recom2 = view.findViewById(R.id.recom2);
                TextView recom3 = view.findViewById(R.id.recom3);
                TextView recom4 = view.findViewById(R.id.recom4);
                TextView recom5 = view.findViewById(R.id.recom5);
                TextView recom6 = view.findViewById(R.id.recom6);
                TextView recom7 = view.findViewById(R.id.recom7);
                TextView recom8 = view.findViewById(R.id.recom8);
                TextView recom9 = view.findViewById(R.id.recom9);
                TextView recom10 = view.findViewById(R.id.recom10);

                ConstraintLayout btnEnd = view.findViewById(R.id.btnEnd);

                txtOrient.setText(model.getOrientationq() + "Б");
                txtName.setText(model.getName());
                txtPam.setText(model.getReproductionq() + "Б");
                txtVospr.setText(model.getSpeakq() + "Б");

                if (!Objects.equals(model.getOrientationq(), "3")){
                    Orient.setTextColor(Color.RED);
                    txtOrient.setTextColor(Color.RED);
                    recom1.setVisibility(View.VISIBLE);
                    recom2.setVisibility(View.VISIBLE);
                    recom3.setVisibility(View.VISIBLE);
                    recom1.setText("Занятия ЛФК");
                    recom2.setText("Применение витаминного комплекса");
                    recom3.setText("Выполнение умственных упражнений");

                    if (!Objects.equals(model.getReproductionq(), "3")){
                        Pam.setTextColor(Color.RED);
                        txtPam.setTextColor(Color.RED);
                        recom4.setVisibility(View.VISIBLE);
                        recom5.setVisibility(View.VISIBLE);
                        recom6.setVisibility(View.VISIBLE);
                        recom7.setVisibility(View.VISIBLE);
                        recom4.setText("Физические упражнения");
                        recom5.setText("Освоение новых навыков");
                        recom6.setText("Читать");
                        recom7.setText("Развивать мелкую моторику");
                    }

                    if (!Objects.equals(model.getSpeakq(), "3")){
                        Vospr.setTextColor(Color.RED);
                        txtVospr.setTextColor(Color.RED);
                        recom4.setVisibility(View.VISIBLE);
                        recom5.setVisibility(View.VISIBLE);
                        recom6.setVisibility(View.VISIBLE);
                        recom7.setVisibility(View.VISIBLE);
                        recom4.setText("Физические упражнения");
                        recom5.setText("Освоение новых навыков");
                        recom6.setText("Читать");
                        recom7.setText("Развивать мелкую моторику");
                    }
                }

                if (!Objects.equals(model.getReproductionq(), "3") && Objects.equals(model.getOrientationq(), "3") ){
                    Pam.setTextColor(Color.RED);
                    txtPam.setTextColor(Color.RED);
                    recom1.setVisibility(View.VISIBLE);
                    recom2.setVisibility(View.VISIBLE);
                    recom3.setVisibility(View.VISIBLE);
                    recom4.setVisibility(View.VISIBLE);
                    recom5.setVisibility(View.VISIBLE);
                    recom1.setText("Физические упражнения");
                    recom2.setText("Освоение новых навыков");
                    recom3.setText("Выполнение умственных упражнений");
                    recom4.setText("Читать");
                    recom5.setText("Развивать мелкую моторику");
                }
                if (!Objects.equals(model.getSpeakq(), "3") && Objects.equals(model.getOrientationq(), "3")){
                    Vospr.setTextColor(Color.RED);
                    txtVospr.setTextColor(Color.RED);
                    recom1.setVisibility(View.VISIBLE);
                    recom2.setVisibility(View.VISIBLE);
                    recom3.setVisibility(View.VISIBLE);
                    recom4.setVisibility(View.VISIBLE);
                    recom5.setVisibility(View.VISIBLE);
                    recom1.setText("Физические упражнения");
                    recom2.setText("Освоение новых навыков");
                    recom3.setText("Выполнение умственных упражнений");
                    recom4.setText("Читать");
                    recom5.setText("Развивать мелкую моторику");
                }

                if (model.getSpeakq().equals("3") && model.getReproductionq().equals("3") && model.getOrientationq().equals("3")){
                    recom1.setVisibility(View.VISIBLE);
                    recom1.setText("Не назначено упражнений.");
                }

                dialogPlus.show();

                btnEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogPlus.dismiss();
                    }
                });
            }
        });

        holder.trashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Удалить?");
                builder.setMessage("После удаления, нельзя востановить.");
                builder.setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("mmse")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView name, subname, orientationq, reproductionq, speakq;

        ConstraintLayout moreBtn, trashBtn;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            subname = (TextView) itemView.findViewById(R.id.subname);
            orientationq = (TextView) itemView.findViewById(R.id.orientationq);
            reproductionq = (TextView) itemView.findViewById(R.id.reproductionq);
            speakq = (TextView) itemView.findViewById(R.id.speakq);
            moreBtn = (ConstraintLayout) itemView.findViewById(R.id.moreBtn);
            trashBtn = (ConstraintLayout) itemView.findViewById(R.id.trashBtn);
        }
    }
}
