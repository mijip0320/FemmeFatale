				parking.put(car, time);
			}
			
		}
		
		int[] ret = new int[cars.size()];
        	// 차번 순으로 정렬
		Collections.sort(cars);
		
		for(int i=0 ; i<cars.size() ; i++) {
        		// 기본요금
			ret[i] = fees[1];
			String car = cars.get(i);
            		// 누적시간중 기본요금 시간 제외
			int time = times.get(car)-fees[0];
            		// 아직 출차가 안되었다면 마지막시간으로 정산
			if(parking.containsKey(car)) time += (lastTime-parking.get(car));
            		// 요금 정산
			if(time>0) ret[i] += (Math.ceil(time/(fees[2]*1.0))*fees[3]);
		}
		
		return ret;
    }
    
    // Convert time String to Integer
    public int getMin(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
	}
}
