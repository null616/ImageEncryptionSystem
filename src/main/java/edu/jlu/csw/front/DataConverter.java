package edu.jlu.csw.front;

import edu.jlu.csw.back.entity.Data;

import java.io.File;
import java.util.ArrayList;

/**
 * @author 10186
 * 是在 ViewModel 和域对象之间转换的类；
 * 这是用于将数据从模型传输到 UI 的纯 Java 对象
 */
public class DataConverter {
    public Data toData(ViewModel viewModel){
        //TODO:
        return new Data(new ArrayList<>(),new File(""),"",false,"");
    }
}
