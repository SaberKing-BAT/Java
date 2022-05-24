package LYC.JDBC.Oracle;

import com.hs.clientManager.entity.AppAdFlawDetection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertBatch {
    public List getData() throws IOException, ClassNotFoundException {
        String fileName="D:\\study\\TempFolder\\serialize.txt";
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
        List<AppAdFlawDetection> list= (List<AppAdFlawDetection>) in.readObject();
        in.close();

       /* for (AppAdFlawDetection a:list
             ) {
            System.out.println(a);
        }*/
        return list;
    }
    public void insertBatch() throws SQLException, IOException, ClassNotFoundException {
        List<AppAdFlawDetection> list=getData().subList(11000,getData().size());
        String sql="insert into APP_AD_FLAW_DETECTION (" +
                "EQUIP_NAME, TEST_DATE, INSPECTOR, LINE_NAME, LINE_TYPE," +
                " ROW_TYPE, STATION, MILEAGE, TRACK_NUMBER, RAIL_NUMBER, " +
                "SWITCH_NUMBER, TRACK_TYPE, FORK_RAIL_TYPE, TURNOUT_NUMBER, EQUIP_TYPE, " +
                "INJURY_LOCATION, INJURY_TYPE, PORE_POSITION, DAMAGE_DEGREE, DAMAGE_DETAILS, " +
                "DAMAGE_CODE, OLD_NEW, FLAW_DETE_EQUIP, RECEIVE_UNIT, RECEIVER, " +
                "RENARKS, RAILWAY_BUREAU, WORKS_SECTION, FLAW_DETE_AREA, LINE_AREA, " +
                "DISCOVERY_UNIT, DISCOVERY_UNIT_TYPE, RAIL_STAMP, PRODUCT_PLANT, MATERIAL, " +
                "THROUGH_YERR, DELIVERY_DATE, BRIDGE_ENTR, RADIUS_CURVE, GRADE, " +
                "RAIL, RAIL_TYPE, LINE_NATURE, \"POSITION\", \"STATUS\") values (?, to_date(?, 'yyyyMMdd'), ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        Connection conn=Conn.getconn();
        PreparedStatement ps=conn.prepareStatement(sql);
        Long startTime=System.currentTimeMillis();
        conn.setAutoCommit(false);
        for (int i=0 ;i<list.size();i++
             ) {
            AppAdFlawDetection a=list.get(i);
            ps.setObject(1,a.getEquipName());
            ps.setObject(2,a.getTestDate());
            ps.setObject(3,a.getInspector());
            ps.setObject(4,a.getLineName());
            ps.setObject(5,a.getLineType());
            ps.setObject(6,a.getRowType());
            ps.setObject(7,a.getStation());
            ps.setObject(8,a.getMileage());
            ps.setObject(9,a.getTrackNumber());
            ps.setObject(10,a.getRailNumber());
            ps.setObject(11,a.getSwitchNumber());
            ps.setObject(12,a.getTrackType());
            ps.setObject(13,a.getForkRailType());
            ps.setObject(14,a.getTurnoutNumber());
            ps.setObject(15,a.getEquipType());
            ps.setObject(16,a.getInjuryLocation());
            ps.setObject(17,a.getInjuryType());
            ps.setObject(18,a.getPorePosition());
            ps.setObject(19,a.getDamageDegree());
            ps.setObject(20,a.getDamageDetails());
            ps.setObject(21,a.getDamageCode());
            ps.setObject(22,a.getOldNew());
            ps.setObject(23,a.getFlawDeteEquip());
            ps.setObject(24,a.getReceiveUnit());
            ps.setObject(25,a.getReceiver());
            ps.setObject(26,a.getRenarks());
            ps.setObject(27,a.getRailwayBureau());
            ps.setObject(28,a.getWorksSection());
            ps.setObject(29,a.getFlawDeteArea());
            ps.setObject(30,a.getLineArea());
            ps.setObject(31,a.getDiscoveryUnit());
            ps.setObject(32,a.getDiscoveryUnitType());
            ps.setObject(33,a.getRailStamp());
            ps.setObject(34,a.getProductPlant());
            ps.setObject(35,a.getMaterial());
            ps.setObject(36,a.getThroughYerr());
            ps.setObject(37,a.getDeliveryDate());
            ps.setObject(38,a.getBridgeEntr());
            ps.setObject(39,a.getRadiusCurve());
            ps.setObject(40,a.getGrade());
            ps.setObject(41,a.getRail());
            ps.setObject(42,a.getRailType());
            ps.setObject(43,a.getLineNature());
            ps.setObject(44,a.getPosition());
            ps.setObject(45,a.getStatus());
            ps.addBatch();
            if((i==list.size()-1||i%1000==0)&&i!=0){   //并没有解决超量的问题，应该是数据有问题吧
                System.out.println(i);
                ps.executeBatch();
                conn.commit();
               // conn.setAutoCommit(false);
                ps.clearBatch();
            }
        }
        ps.executeBatch();
        conn.commit();
        //ps.executeBatch();
       // conn.commit();
        System.out.println("用时:"+(System.currentTimeMillis()-startTime));
    }
    /*非正规写法，不推荐*/
    public void insertBatch2() throws SQLException, IOException, ClassNotFoundException {
        List<AppAdFlawDetection> list=getData();
        String sql="insert into APP_AD_FLAW_DETECTION (" +
                "EQUIP_NAME, TEST_DATE, INSPECTOR, LINE_NAME, LINE_TYPE," +
                " ROW_TYPE, STATION, MILEAGE, TRACK_NUMBER, RAIL_NUMBER, " +
                "SWITCH_NUMBER, TRACK_TYPE, FORK_RAIL_TYPE, TURNOUT_NUMBER, EQUIP_TYPE, " +
                "INJURY_LOCATION, INJURY_TYPE, PORE_POSITION, DAMAGE_DEGREE, DAMAGE_DETAILS, " +
                "DAMAGE_CODE, OLD_NEW, FLAW_DETE_EQUIP, RECEIVE_UNIT, RECEIVER, " +
                "RENARKS, RAILWAY_BUREAU, WORKS_SECTION, FLAW_DETE_AREA, LINE_AREA, " +
                "DISCOVERY_UNIT, DISCOVERY_UNIT_TYPE, RAIL_STAMP, PRODUCT_PLANT, MATERIAL, " +
                "THROUGH_YERR, DELIVERY_DATE, BRIDGE_ENTR, RADIUS_CURVE, GRADE, " +
                "RAIL, RAIL_TYPE, LINE_NATURE, \"POSITION\", STATUS) values (?, to_date(?, 'yyyyMMdd'), ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        Connection conn=Conn.getconn();
        Long startTime=System.currentTimeMillis();
        int n=list.size();
        n=n%3000==0?(n/3000):(n/3000+1);
        for (int j=0;j<n;j++){
            PreparedStatement ps=conn.prepareStatement(sql);
            //conn.setAutoCommit(false);
            for (int i=0 ;i<list.subList(0+j*3000,j!=n-1?j*3000+3000:list.size()).size();i++
            ) {
                AppAdFlawDetection a=list.get(i);
                ps.setObject(1,a.getEquipName());
                ps.setObject(2,a.getTestDate());
                ps.setObject(3,a.getInspector());
                ps.setObject(4,a.getLineName());
                ps.setObject(5,a.getLineType());
                ps.setObject(6,a.getRowType());
                ps.setObject(7,a.getStation());
                ps.setObject(8,a.getMileage());
                ps.setObject(9,a.getTrackNumber());
                ps.setObject(10,a.getRailNumber());
                ps.setObject(11,a.getSwitchNumber());
                ps.setObject(12,a.getTrackType());
                ps.setObject(13,a.getForkRailType());
                ps.setObject(14,a.getTurnoutNumber());
                ps.setObject(15,a.getEquipType());
                ps.setObject(16,a.getInjuryLocation());
                ps.setObject(17,a.getInjuryType());
                ps.setObject(18,a.getPorePosition());
                ps.setObject(19,a.getDamageDegree());
                ps.setObject(20,a.getDamageDetails());
                ps.setObject(21,a.getDamageCode());
                ps.setObject(22,a.getOldNew());
                ps.setObject(23,a.getFlawDeteEquip());
                ps.setObject(24,a.getReceiveUnit());
                ps.setObject(25,a.getReceiver());
                ps.setObject(26,a.getRenarks());
                ps.setObject(27,a.getRailwayBureau());
                ps.setObject(28,a.getWorksSection());
                ps.setObject(29,a.getFlawDeteArea());
                ps.setObject(30,a.getLineArea());
                ps.setObject(31,a.getDiscoveryUnit());
                ps.setObject(32,a.getDiscoveryUnitType());
                ps.setObject(33,a.getRailStamp());
                ps.setObject(34,a.getProductPlant());
                ps.setObject(35,a.getMaterial());
                ps.setObject(36,a.getThroughYerr());
                ps.setObject(37,a.getDeliveryDate());
                ps.setObject(38,a.getBridgeEntr());
                ps.setObject(39,a.getRadiusCurve());
                ps.setObject(40,a.getGrade());
                ps.setObject(41,a.getRail());
                ps.setObject(42,a.getRailType());
                ps.setObject(43,a.getLineNature());
                ps.setObject(44,a.getPosition());
                ps.setObject(45,a.getStatus());
                ps.addBatch();
            }
            ps.executeBatch();
        }

        //ps.executeBatch();
        // conn.commit();
        System.out.println("用时:"+(System.currentTimeMillis()-startTime));
    }

    public void insertBatch3() throws SQLException {
        String sql="insert into SYS_STUDENT (STU_NUM,STU_NAME,STU_SEX,STU_BIRTH,STU_DEPT) values(?,?,?,?,?)";
        Connection conn=Conn.getconn();
        PreparedStatement ps=conn.prepareStatement(sql);
        conn.setAutoCommit(false);
        for(int i=0;i<200000;i++){
            ps.setObject(1,i);
            ps.setObject(2,i);
            ps.setObject(3,1);
            ps.setObject(4,i);
            ps.setObject(5,i);
            ps.addBatch();
            if((i%2000==0||i==200000-1)&&i!=0){
                System.out.println(i);
                ps.executeBatch();
                conn.commit();
                ps.clearBatch();
            }
        }
        ps.close();
        conn.close();
    }
    public static void main(String[] args) throws Exception {
        InsertBatch in=new InsertBatch();
//        in.getData();
      //  in.insertBatch2();
       // in.insertBatch();
        in.insertBatch3();
    }
}
