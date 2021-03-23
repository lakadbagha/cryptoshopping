package crypto.blockchain.shopviacrypto.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.blockchain.shopviacrypto.dto.PurchaseTransaction;
import crypto.blockchain.shopviacrypto.repository.PurchaseTransactionRepository;

@Service
public class PurchaseTransactionDao {

	@Autowired
	PurchaseTransactionRepository purchaseTransactionRepository;

	public void savePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		purchaseTransaction.setModifiedDate(modifiedDate);
		purchaseTransaction.setCreatedDate(modifiedDate);
		purchaseTransaction.setIsDeleted(false);
		purchaseTransaction.setIsCanceled(false);
		purchaseTransactionRepository.save(purchaseTransaction);
	}

	public void updatePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		purchaseTransaction.setModifiedDate(modifiedDate);
		purchaseTransactionRepository.save(purchaseTransaction);
	}

	public void deletePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		Calendar cal = Calendar.getInstance();
		Timestamp modifiedDate = new Timestamp(cal.getTime().getTime());
		purchaseTransaction.setModifiedDate(modifiedDate);
		purchaseTransaction.setIsDeleted(true);
		purchaseTransactionRepository.save(purchaseTransaction);
	}

	public PurchaseTransaction findPurchasedTransactionById(Long transactionId,Boolean isOrderComplete, Boolean isDeleted,Boolean isSaveForLater) {
		return purchaseTransactionRepository.findByTransactionIdAndCartOrderCompleteAndCartIsDeletedAndCartSaveForLater(transactionId, isOrderComplete, isDeleted, isSaveForLater).orElse(null);
	}

	public List<PurchaseTransaction> findPurchasedTransactionByUserId(Long userId, Boolean isCanceled,
			Boolean isDeleted, Boolean isOrderComplete, Boolean isCartDeleted) {
		return purchaseTransactionRepository
				.findByAccountUserIdAndIsCanceledAndIsDeletedAndCartOrderCompleteAndCartIsDeleted(userId, isCanceled,
						isDeleted, isOrderComplete, isCartDeleted);
	}

	public List<PurchaseTransaction> findAllPurchasedTransaction() {
		return purchaseTransactionRepository.findAll();
	}


	public Long getInvoiceId() {
		return purchaseTransactionRepository.count();
	}

}
