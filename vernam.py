def encrypt(string, key, i=0):
	ct=[]
	for x in string:
		ct.append(abc[(abc.index(x) + abc.index(key[i%len(key)]))%len(abc)])
		i+=1
	print "Cipher Text: ", ''.join(ct)
	return (''.join(ct))

def decrypt(string , key, i=0):
	pt=[]
	for x in string:
		pt.append(abc[abs(abc.index(x) - abc.index(key[i%len(key)]))%len(abc)])
		i+=1
	print "Plain Text: ", ''.join(pt)

abc = "abcdefghijklmnopqrstuvwxyz "
key = raw_input("Please enter the key: ")
decrypt(encrypt(raw_input("Please enter the Plain Text: "), key), key)