#zombit

def answer(meetings):
	meetings_sort = sorted(meetings, key=lambda x: x[1])
	final = []
	flag = True
	for meet in meetings_sort:
		for schedmeet in final:
			if meet[0] < schedmeet[1]:
				if meet[1] > schedmeet[0]:
					flag = False
			elif meet[1] > schedmeet[0]:
				if meet[0] < schedmeet[1]:
					flag = False
		if flag:
			final.append(meet)
		flag = True
	return len(final)
