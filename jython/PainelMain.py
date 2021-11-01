from javax.swing import JFrame, JLabel, JButton, JTextField, JComboBox, WindowConstants, JPanel
from java.awt import Dimension
from java.lang import Object
from string import upper
from compiler.ast import If

frame = JFrame("A melhor rota de entrega da regiao do vale do paraiba")
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
frame.setLocation(400,40)
frame.setSize(500,700)
frame.setLayout(None)
frame.setResizable(0);
 
class Item(Object):
    def __init__(self, item):
        self.key = item["key"]
        self.name = item["name"]

    def toString(self):
        return self.name
       
item1 = {'key': 'item1', 'name': 'Busca Sem Info'}
item2 = {'key': 'item2', 'name': 'Busca Sem Info Multi'}
item3 = {'key': 'item3', 'name': 'Busca Com Pesos'}
combo_box = JComboBox([Item(item1), Item(item2),Item(item3)])
combo_box.setBounds(150,10,200,20)

def add(event):
    print upper(txt1.getText())
    ttl = int(txt1.getText())+int(txt2.getText())
    txt3.setText(str(ttl))
    
    
lbl1 = JLabel("Origem")
lbl1.setBounds(40,40,60,20)
txt1 = JTextField(100)
txt1.setBounds(100,40,300,20)

lbl2 = JLabel("Destino")
lbl2.setBounds(40,70,60,20)
txt2 = JTextField(100)
txt2.setBounds(100, 70, 300,20)

lbl3 = JLabel("Limite")
lbl3.setBounds(40,100,60,20)
txt3 = JTextField(100)
txt3.setBounds(100,100, 300,20)

btn = JButton("Executar", actionPerformed = add)
btn.setBounds(195,130,100,20)

lbl4 = JLabel("Resultados")
lbl4.setBounds(210,160,100,20)

lbl5 = JLabel("Amplitude")
lbl5.setBounds(210,190,100,20)
txt5 = JTextField(100)
txt5.setBounds(100, 210,300,20)

lbl6 = JLabel("Profundidade")
lbl6.setBounds(200,240,100,20)
txt6 = JTextField(100)
txt6.setBounds(100, 260,300,20)

lbl7 = JLabel("Profundidade Limitada")
lbl7.setBounds(170,290,150,20)
txt7 = JTextField(100)
txt7.setBounds(100,310,300,20)

lbl8 = JLabel("Bidirecional")
lbl8.setBounds(200,340,150,20)
txt8 = JTextField(100)
txt8.setBounds(100, 360,300,20)

lbl9 = JLabel("Aprofundamento Iterativo")
lbl9.setBounds(170,390,150,20)
txt9 = JTextField(100)
txt9.setBounds(100, 410,300,20)

lbl10 = JLabel("Greedy")
lbl10.setBounds(220,440,150,20)
txt10 = JTextField(100)
txt10.setBounds(100, 460,300,20)

lbl11 = JLabel("A estrela")
lbl11.setBounds(220,490,150,20)
txt11 = JTextField(100)
txt11.setBounds(100, 510,300,20)

lbl12 = JLabel("Custo Uniforme")
lbl12.setBounds(200,540,150,20)
txt12 = JTextField(100)
txt12.setBounds(100,560,300,20)

frame.add(combo_box)
frame.add(btn)
frame.add(lbl1)
frame.add(txt1)
frame.add(lbl2)
frame.add(txt2)
frame.add(lbl3)
frame.add(txt3)
frame.add(lbl4)
frame.add(lbl5)
frame.add(txt5)
frame.add(lbl6)
frame.add(txt6)
frame.add(lbl7)
frame.add(txt7)
frame.add(lbl8)
frame.add(txt8)
frame.add(lbl9)
frame.add(txt9)
frame.add(lbl10)
frame.add(txt10)
frame.add(lbl11)
frame.add(txt11)
frame.add(lbl12)
frame.add(txt12)

frame.setVisible(True)