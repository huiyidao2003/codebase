package org.victor.bdp.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;

/**
 * Created by zhengcunwen on 2017/7/19.
 */
@Description(name = "csm_explode", value = "_FUNC_(a) - separates the elements of string with '|'   into multiple rows")
public class CSMUDTFExplode extends GenericUDTF {
    @Override
    public void close() throws HiveException {
    }

    @Override
    public StructObjectInspector initialize(ObjectInspector[] args)
            throws UDFArgumentException {
        if (args.length != 1) {
            throw new UDFArgumentException("csm_explode() takes only one argument");
        }

        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
        //返回的新列的字段名称
        fieldNames.add("tag");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(
                fieldNames, fieldOIs);
    }


    @Override
    public void process(Object[] o) throws HiveException {
        String input = o[0].toString();
        String[] test = input.split("\\|");
        //forward处理一个数组，每个数组作为一行返回，每个数组里的元素作为一列
        for(int i =0 ;i < test.length;i ++){
            String[] tag = {test[i]};
            forward(tag);
        }

    }

    @Override
    public String toString() {
        return "";
    }
}
