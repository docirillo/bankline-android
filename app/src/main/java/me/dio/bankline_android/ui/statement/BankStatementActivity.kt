package me.dio.bankline_android.ui.statement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import me.dio.bankline_android.databinding.ActivityBankStatementBinding
import me.dio.bankline_android.domain.Correntista
import me.dio.bankline_android.domain.Movimentacao
import me.dio.bankline_android.domain.TipoMovimentacao
import me.dio.bankline_android.ui.adapters.BankStatementAdapter

class BankStatementActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ACCOUNT_HOLDER = "me.dio.bankline_android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER)
            ?: throw IllegalArgumentException()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1,"03/05/2022 18:44:55", "Lorem Ipsum", 1000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1,"03/05/2022 18:44:55", "Lorem Ipsum", 1000.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1,"03/05/2022 18:44:55", "Lorem Ipsum", 1000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1,"03/05/2022 18:44:55", "Lorem Ipsum", 1000.0, TipoMovimentacao.DESPESA, 1))
        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)

    }
}