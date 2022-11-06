import pipes

t = pipes.Template()
f = t.open('pipefile', 'w')
f.write("00 01 10")
f.close()