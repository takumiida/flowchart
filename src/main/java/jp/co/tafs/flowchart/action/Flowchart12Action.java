package jp.co.tafs.flowchart.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flowchart12Action {

	public static void main(String[] args) {

		//入力チェック
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);

		try {
			sdf.parse(args[0]);
			sdf.parse(args[1]);
		} catch (ParseException e) {
			System.out.println("入力が正しくありません");
			return;
		}

		//１つめの日数計算
		String[] date = args[0].split("\\/");
		int year = Integer.valueOf(date[0]);
		int mon = Integer.valueOf(date[1]);
		int day = Integer.valueOf(date[2]);
		int dSum = 0;

		dSum = change(year, mon, day);

		//2つめの日数計算
		String[] sdate = args[1].split("\\/");
		int syear = Integer.valueOf(sdate[0]);
		int smon = Integer.valueOf(sdate[1]);
		int sday = Integer.valueOf(sdate[2]);
		int sdSum = 0;

		sdSum = change(syear, smon, sday);

		//経過日数と経過時間の計算
		int sum = 0;
		int tSum = 0;

		if (dSum >= sdSum) {
			sum = dSum - sdSum;
			tSum = sum * 24;
		} else {
			sum = sdSum - dSum;
			tSum = sum * 24;
		}

		//表示
		System.out.println("経過日数: " + sum + "日");
		System.out.println("経過時間: " + tSum + "時間");
	}

	//日数計算の処理
	public static int change(int year, int mon, int day) {

		if (mon < 3) {
			year = year - 1;
			mon = mon + 12;
		}

		int ySum = (year * 365) + (year / 4) - (year / 100) + (year / 400);
		int mSum = (mon * 30) + ((mon + 1) * 3 / 5 - 33);
		int dSum = ySum + mSum + day;

		return dSum;
	}

}