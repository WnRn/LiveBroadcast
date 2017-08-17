package wr.bc.com.livebroadcast.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import okhttp3.FormBody;
import retrofit2.Call;
import wr.bc.com.livebroadcast.R;
import wr.bc.com.livebroadcast.adapter.ChoiceAdapter;
import wr.bc.com.livebroadcast.api.LiveApi;
import wr.bc.com.livebroadcast.bean.LiveBean;
import wr.bc.com.livebroadcast.fragment.base.BaseNetFragment;
import wr.bc.com.livebroadcast.network.RetrofitManager;


/**
 * Created by Administrator on 2017/8/15.
 */

public class ChoiceFragment extends BaseNetFragment<LiveBean> {

    private RecyclerView recyclerView;
    private List<LiveBean.ResultBean.ListBean> list;

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = View.inflate(getActivity(), R.layout.choice, null);
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_choice);
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            list.add("我是" + i);
//        }
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        ChoiceAdapter choiceAdapter = new ChoiceAdapter(getActivity(), list);
//        recyclerView.setAdapter(choiceAdapter);
//
//        return view;
//    }

    @Override
    protected int getContentResId() {
        return R.layout.choice;
    }

    @Override
    protected void initViews() {
        recyclerView = getActivity().findViewById(R.id.rv_choice);
    }

    @Override
    protected void loadData() {
        LiveApi liveApi = RetrofitManager.getTestRetrofit().create(LiveApi.class);
        FormBody formBody = new FormBody.Builder()
                .add("type","1")
                .add("page","1")
                .build();
        Call<LiveBean> testCall = liveApi.getLive(formBody);
        testCall.enqueue(this);
    }

    @Override
    protected void processData(LiveBean live) {
//        goneLoading();
        init(live);
    }

    private void init(LiveBean live) {
        list = live.getResult().getList();
//        Log.d("ddd","live:"+live.getResult().getList().get(0).getUser().getUser_data().getAvatar());
//        Log.d("aaa","live:"+live.getResult().getList().get(0).getData().getPic());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ChoiceAdapter choiceAdapter = new ChoiceAdapter(getActivity(), list);
        recyclerView.setAdapter(choiceAdapter);
    }

}
