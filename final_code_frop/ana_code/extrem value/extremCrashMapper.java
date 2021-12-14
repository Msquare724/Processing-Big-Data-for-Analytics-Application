import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class extremCrashMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String data[] = value.toString().split(",");

        if((int)Double.parseDouble(data[2]) == 100 || ((int)Double.parseDouble(data[2])) == 47){

            String temp = String.valueOf(((int)Double.parseDouble(data[2])));
            String date = data[0];
            String hour = data[1];

            String output = date + "," + hour + "," + temp;

            context.write(new Text(output), new IntWritable(Integer.valueOf(data[3]));
        }
    }
} 

