import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class TelaPrincipal extends javax.swing.JFrame {
private List<Pessoa> pessoas;
private int indiceAtual;
private TelaCadPessoa telaCadPessoa;
public TelaPrincipal() {
initComponents();
pessoas = new ArrayList<>();
indiceAtual = -1;
pessoas.add(new Pessoa("Ana Silva", "ana@email.com"));
pessoas.add(new Pessoa("Carlos Souza", "carlos@email.com"));
if (!pessoas.isEmpty()) {
indiceAtual = 0;
}
}
private void abrirTelaCadastro() {
if (telaCadPessoa == null || !telaCadPessoa.isVisible()) {
telaCadPessoa = new TelaCadPessoa(this);
}
telaCadPessoa.setVisible(true);
atualizarTelaCadPessoa();
}
public void atualizarTelaCadPessoa() {
if (telaCadPessoa != null) {
if (indiceAtual == -1 || pessoas.isEmpty()) {
telaCadPessoa.limparCampos();
} else {
Pessoa p = pessoas.get(indiceAtual);
telaCadPessoa.exibirPessoa(p);
}
}
}
public void excluirPessoaAtual() {
if (pessoas == null || pessoas.isEmpty() || indiceAtual < 0 || indiceAtual >= pessoas.size()) {
JOptionPane.showMessageDialog(this,
"Não há pessoa selecionada para excluir.",
"Aviso",
JOptionPane.WARNING_MESSAGE);
return;
}
int opcao = JOptionPane.showConfirmDialog(
this,
"Deseja realmente excluir esta pessoa?",
"Confirmação de exclusão",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE
);
if (opcao == JOptionPane.YES_OPTION) {
pessoas.remove(indiceAtual);
if (pessoas.isEmpty()) {
indiceAtual = -1;
} else if (indiceAtual >= pessoas.size()) {
indiceAtual = pessoas.size() - 1;
}
atualizarTelaCadPessoa();
JOptionPane.showMessageDialog(this,
"Pessoa excluída com sucesso!",
"Sucesso",
JOptionPane.INFORMATION_MESSAGE);
}
}
private void initComponents() {
btnAbrirCadastro = new javax.swing.JButton();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("Tela Principal");
btnAbrirCadastro.setText("Abrir Cadastro / Gerenciar");
btnAbrirCadastro.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
abrirTelaCadastro();
}
});
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(110, 110, 110)
.addComponent(btnAbrirCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(110, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(120, 120, 120)
.addComponent(btnAbrirCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(120, Short.MAX_VALUE))
);
pack();
setLocationRelativeTo(null);
}
private javax.swing.JButton btnAbrirCadastro;
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new TelaPrincipal().setVisible(true);
}
});
}
}